package com.jk.mapper;

import com.jk.model.LunBo;
import com.jk.model.TreeBean;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CkMapper {
    Integer selectCount();

    List<User> selectUser();

    void addLunBoTu(LunBo lunBo);

    Integer selectLunBoCount();

    List<LunBo> selectLunBo(@Param(value = "start") Integer start,
                            @Param(value = "pageSize") Integer pageSize);

    void updateLunBo(LunBo lunBo);

    LunBo selectLunById(Integer id);

    void deleteLun(Integer id);

    void updateStatus(Integer id, Integer zt);

    List<TreeBean> selectTree();

    List<LunBo> selectLunZhan();
}
