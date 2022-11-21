package com.bjpn.mapper;

import com.bjpn.bean.Student;

public interface StudentMapper1 {
    //删除的方法
    int delStudent(int sid);
    //修改的方法
    int updateStudentById(Student student);
    //查询的方法
}
