package com.bjpn.test;

import com.bjpn.bean.User;
import com.bjpn.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDemo3 {
    @Test
    public void testSelectUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSessionFactory  有jdbc对象  sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllUser();
        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void testAddUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSessionFactory  有jdbc对象  sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("宋江");
        user.setUserCode("888666");
        user.setUserPwd("123");
        int num = userMapper.addUser(user);
        if(num>0){
            System.out.println("成功");
            sqlSession.commit();
        }else{
            System.out.println("失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
    @Test
    public void testDelUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSessionFactory  有jdbc对象  sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int num = userMapper.delUserById(5);
        if(num>0){
            System.out.println("成功");
            sqlSession.commit();
        }else{
            System.out.println("失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
    @Test
    public void selectByMap() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSessionFactory  有jdbc对象  sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("codeKey", "888123");
        map.put("pwdKey","123");
        User user = userMapper.loginUserByMap(map);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void selectByParam() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSessionFactory  有jdbc对象  sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取userMapper实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.loginUser("888222", "123");
        System.out.println(user);
        sqlSession.close();
    }
}
