package com.bjpn.mapper;

import com.bjpn.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询所有
    List<User> findAllUser();
    //删除
    int delUserById(int uid);
    //添加
    int  addUser(User user);
    //登录
   /* User loginUser(String userCode,String userPwd);*/
    //map登录
    User loginUserByMap(Map map);
    //登录
    User loginUser(@Param("userCode") String userCode, @Param("pwd") String userPwd);
}
