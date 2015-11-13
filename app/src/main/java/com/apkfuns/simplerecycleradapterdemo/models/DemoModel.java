package com.apkfuns.simplerecycleradapterdemo.models;

import java.util.List;

/**
 * Created by pengwei08 on 15/11/13.
 */
public class DemoModel {
    public String name;
    public int stuId;
    public int ClassId;
    public List<Subject> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public List<Subject> getList() {
        return list;
    }

    public void setList(List<Subject> list) {
        this.list = list;
    }

    public class Subject{
        public String subjectName;
        public float score;
    }
}
