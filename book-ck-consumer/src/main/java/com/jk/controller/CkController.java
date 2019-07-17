package com.jk.controller;

import com.jk.model.LunBo;
import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.service.CkServiceFeign;
import com.jk.util.OSSClientUtil;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.metrics.percentiles.hdr.InternalHDRPercentileRanks;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController

public class CkController {

    @Autowired
    private CkServiceFeign feign;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("aaa")
    public User text(){
        User user = new User();
        user.setAccount("chenkai");
        user.setPassword("chenkaizuishuai");
        User user1 = feign.text(user);
        return user1;

    }

    @GetMapping("selectUser")
    @CrossOrigin
    public HashMap<String,Object>  selectUser(){
        return feign.selectUser();
    }

    /**
     * OSS阿里云上传图片
     */
    @PostMapping("updaloadImg")
    @ResponseBody
    public HashMap<String, Object> uploadImg(MultipartFile imgg) throws IOException {

        if (imgg == null || imgg.getSize() <= 0) {



            throw new IOException("file不能为空");

        }

        OSSClientUtil ossClient = new OSSClientUtil();

        String name = ossClient.uploadImg2Oss(imgg);

        String imgUrl = ossClient.getImgUrl(name);

        //  String[] split = imgUrl.split("\\?");



        HashMap<String, Object> map = new HashMap<>();

        map.put("imngName", imgUrl);



        return  map;

    }

    @PostMapping("addLunBoTu")
    @CrossOrigin
    public void addLunBoTu(LunBo lunBo){
        feign.addLunBoTu(lunBo);

    }


    @GetMapping("selectLunBo")
    @CrossOrigin
    public HashMap<String,Object>  selectLunBo(@RequestParam(value = "start") Integer start,
                                               @RequestParam(value = "pageSize") Integer pageSize){
        return feign.selectLunBo(start,pageSize);

    }

    @PutMapping("updateLunBo")
    @CrossOrigin
    public void  updateLunBo(LunBo lunBo){
        feign.updateLunBo(lunBo);
    }

    @DeleteMapping("deleteLun")
    @CrossOrigin
    public void  deleteLun(@RequestParam(value = "id")Integer id){
        feign.deleteLun(id);
    }

    @PutMapping("updateStatus")
    @CrossOrigin
    public void  updateStatus(@RequestParam(value = "id")Integer id,
                              @RequestParam(value = "zt")Integer zt){
        feign.updateStatus(id,zt);
    }

    //查询树
    @CrossOrigin
    @GetMapping("selectTree")
    public List<TreeBean>  selectTree(){
        Integer pid = -1;
        List<TreeBean> list = getTreeBeans(pid);
        return list;

    }

    private List<TreeBean> getTreeBeans(Integer pid) {
        List<TreeBean>  treeBeanList = feign.selectTree(pid);
        for (TreeBean treeBean : treeBeanList) {
            Integer treeBeanId = treeBean.getId();
            List<TreeBean> beanList = getTreeBeans(treeBeanId);
            treeBean.setNodes(beanList);
        }
        
        return  treeBeanList;
    }

    @CrossOrigin
    @GetMapping("selectLunZhan")
    public List<LunBo>  selectLunZhan(){
        List<LunBo> list = feign.selectLunZhan();
        String lun = "lunbotu";
        if (redisTemplate.hasKey(lun)){
            redisTemplate.delete(lun);
        }
        redisTemplate.opsForList().rightPushAll(lun,list);
        List<LunBo> lunBoList = (List<LunBo>) redisTemplate.opsForList().range(lun,0,-1);
        for (int i = 0; i < lunBoList.size(); i++) {
            System.out.println(lunBoList.get(i).toString());

        }
        return lunBoList;
    }


    //es轮播图
    @CrossOrigin
    @RequestMapping("selectLunByEs")
    public HashMap<String,Object>  selectCommodity(Integer start,Integer pageSize,LunBo lunBo){
        HashMap<String, Object> map = new HashMap<>();
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("sanzu").setTypes("t_lunbotu");
        if (lunBo.getImgName()!=null&&lunBo.getImgName()!=""){
            searchRequestBuilder.setQuery(QueryBuilders.matchQuery("imgName",lunBo.getImgName()));
        }

        if (lunBo.getImgName()!=null&&lunBo.getImgName()!=""){
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("imgName").preTags("<font  color='red'>").postTags("</font>");

            searchRequestBuilder.highlighter(highlightBuilder).setFrom(start).setSize(pageSize);;
        }

        searchRequestBuilder.setFrom(start).setSize(pageSize);
        SearchResponse searchResponse = searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();
        int total = (int) hits.totalHits;
        Iterator<SearchHit> iterator = hits.iterator();
        ArrayList<Object> list = new ArrayList<>();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            if (lunBo.getImgName()!=null&&lunBo.getImgName()!=""){
                Map<String, HighlightField> highlightFields = next.getHighlightFields();
                HighlightField cname = highlightFields.get("imgName");
                Map<String, Object> sourceAsMap = next.getSourceAsMap();
                Text[] fragments = cname.fragments();
                sourceAsMap.put("imgName",String.valueOf(fragments[0]));
            }

            Map<String, Object> sourceAsMap = next.getSourceAsMap();

            list.add(sourceAsMap);
        }
        map.put("rows",list);
        map.put("total",total);
        return  map;

    }

}
