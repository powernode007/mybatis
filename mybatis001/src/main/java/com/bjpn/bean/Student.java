package com.bjpn.bean;

import java.util.Objects;

public class Student {
    private int sid;
    private String sname;
    private String ssex;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sid == student.sid &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(ssex, student.ssex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, ssex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                '}';
    }

    public Student(int sid, String sname, String ssex) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
    }
    public Student(){}
}
