package com.jk.mapper;

import com.jk.model.User;

import java.util.List;

public interface CkMapper {
    Integer selectCount();

    List<User> selectUser();
}
