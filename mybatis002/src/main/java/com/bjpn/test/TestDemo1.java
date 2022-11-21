package com.bjpn.test;

import com.bjpn.bean.Emp;
import com.bjpn.mapper.EmpMapper;

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
    public void testAddEmp() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("金莲");
        emp.setEmpJob("财务");
        emp.setEmpSal(10000);
        boolean b = empMapper.addEmp(emp);
        if(b){
            sqlSession.commit();
            System.out.println("成功");
        }else{
            sqlSession.rollback();
            System.out.println("失败");
        }
        sqlSession.close();
    }
    @Test
    public void testSelectEmp() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.findAllEmp();
        for(Emp emp :empList){
            System.out.println(emp);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectEmpBySal() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = empMapper.findAllEmpBySal(20000);
        for(Emp emp :empList){
            System.out.println(emp);
        }
        sqlSession.close();
    }
    @Test
    public void testSelectEmpByName() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("金莲");
        emp.setEmpJob("财务");
        List<Emp> empList = empMapper.findAllEmpByNameAndJob(emp);
        for(Emp emp1 :empList){
            System.out.println(emp1);
        }
        sqlSession.close();
    }
    @Test
    public void testUpdateEmp() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("武大");
        /*emp.setEmpJob("财务");*/
        emp.setEmpSal(25000);
        emp.setEmpNo(1);
        boolean b = empMapper.updateEmp(emp);
        if(b){
            sqlSession.commit();
            System.out.println("成功");
        }else{
            sqlSession.rollback();
            System.out.println("失败");
        }
        sqlSession.close();
    }
    @Test
    public void testAddEmp1() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = new Emp();
        emp.setEmpName("秦明");
        //emp.setEmpJob("产品");
        emp.setEmpSal(20000);
        emp.setEmpHiredate("2022-08-08");
        boolean b = empMapper.addEmpSective(emp);
        if(b){
            sqlSession.commit();
            System.out.println("成功");
        }else{
            sqlSession.rollback();
            System.out.println("失败");
        }
        sqlSession.close();
    }
    @Test
    public void testSelectEmpArray() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        int[] arr = {1,3,5,8,66};
        List<Emp> empList = empMapper.findEmpByArray(arr);
        for(Emp emp1 :empList){
            System.out.println(emp1);
        }
        sqlSession.close();
    }
}
