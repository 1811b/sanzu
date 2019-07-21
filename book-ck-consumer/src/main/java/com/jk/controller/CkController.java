package com.jk.controller;

import com.jk.model.*;
import com.jk.repository.LunBoTuRepository;
import com.jk.service.CkServiceFeign;
import com.jk.util.OSSClientUtil;
import org.apache.commons.lang.time.FastDateFormat;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Autowired
    private LunBoTuRepository lunBoTuRepository;

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
    @RequestMapping("selectTree")

    public  List<TreeBean>  selectTree(){
        Integer pid=-1;
        List<TreeBean>	list = getTree(pid);
        return list;

    }


    private List<TreeBean> getTree(Integer pid) {
        List<TreeBean>	list = feign.selectTree(pid);
        for (TreeBean tree : list) {
            Integer id = tree.getTid();
            List<TreeBean> list2 = getTree(id);
            tree.setNodes(list2);

        }
        return list;
    }

    @CrossOrigin
    @GetMapping("selectLunZhan")
    public List<LunBo>  selectLunZhan(){
        List<LunBo> list = feign.selectLunZhan();

        return list;
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


    //商品编号生成
    private static final FastDateFormat pattern = FastDateFormat.getInstance("yyyyMMddHHmmss");
    private static final AtomicInteger atomicInteger = new AtomicInteger(1);
    private static ThreadLocal<StringBuilder> threadLocal = new ThreadLocal<StringBuilder>();
    @RequestMapping("bianHao")
    public String bianHao(){
        StringBuilder builder = new StringBuilder(pattern.format(Instant.now().toEpochMilli()));// 取系统当前时间作为订单号前半部分
        builder.append(atomicInteger.getAndIncrement());// 自增顺序
        threadLocal.set(builder);
        System.out.println(threadLocal.get().toString());
        return threadLocal.get().toString();
    }



    //商品展示
    @GetMapping("selectBookZheng")
    public List<Book>  selectBookZheng(){
       List<Book>  list = feign.selectBookZheng();
       return list;
    }


    //登录
    @RequestMapping("login")
    public  String  login(UserBean userBean){
        UserBean  user2 = feign.login(userBean);
        if (user2==null) {
            return  "fail";
        }
        return "success";

    }





}
