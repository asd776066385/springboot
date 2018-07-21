package com.base.springboot.mapper;

import com.base.springboot.model.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {


    @Select("select * from test_user")
    List<UserVO> getList();
}
