package com.bjpn.mapper;

import com.bjpn.bean.Emp;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface EmpMapper {
    //添加

    boolean addEmp(Emp  emp);
    //查询

    List<Emp> findAllEmp();
    //查询
    List<Emp> findAllEmpBySal(double empSal);
    //查询名字和工种
    List<Emp> findAllEmpByNameAndJob(Emp emp);
    //修改
    boolean  updateEmp(Emp emp);
    //非空字段添加
    boolean addEmpSective(Emp emp);
    //批量查询
    List<Emp> findEmpByArray(int[] intArr);
}
