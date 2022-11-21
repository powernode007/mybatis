package com.bjpn.test;

import com.bjpn.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo1 {
    @Test
    public void testSelectStudent() throws IOException {
        //使用mybatis帮我们完成数据库操作
        //1、获取sqlSessionFactory   根据我们的连接参数  sql语句  创建jdbc对象  sql语句
        // 把操作数据库的方式 交给SqlSession对象
        //读取核心配置文件  获取连接参数和sql语句
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //2、获取SqlSession  jdbc对象  有sql语句  可以直接执行
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、从sqlSession中得到我们要执行的内容
        /*Student student = sqlSession.selectOne("aaa.findStudent");
        System.out.println("查询到的student:"+student);
        sqlSession.close();*/
        List<Student> studentList = sqlSession.selectList("aaa.findStudent");

        for(Student student :studentList){
            System.out.println(student);
        }
        sqlSession.close();

    }
    @Test
    public void testAddUser() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = new Student();
        student.setSname("小王");
        student.setSsex("男");
        int num = sqlSession.insert("aaa.addStudent", student);
        if(num>0){
            System.out.println("添加成功");
            sqlSession.commit();
        }else{
            System.out.println("失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
