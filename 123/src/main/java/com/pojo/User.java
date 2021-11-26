package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String sno;            //学号
    private String sname;       //姓名
    private String sgrade;      //年级
    private String sphone;         //联系方式
    private String sschool;     //学院
    private String sdept;       //专业
    private String sinfo;       //个人简介
    private String steacher;    //辅导员


}
