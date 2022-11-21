package com.bjpn.test;

import com.bjpn.mapper.StudentMapper1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDemo2 {
    @Test
    public void TestStudentDel() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //sqlSessionFactory  有jdbc对象  sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //使用动态代理对象  生成接口实现类
        StudentMapper1 studentMapper1 = sqlSession.getMapper(StudentMapper1.class);//实现类
        int num =  studentMapper1.delStudent(4);
        if(num>0){
            System.out.println("成功");
            sqlSession.commit();
        }else{
            System.out.println("失败");
            sqlSession.rollback();
        }
        sqlSession.close();
    }
}
