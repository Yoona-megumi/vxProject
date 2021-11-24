package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private int tno;            //工号
    private String tname;       //姓名
    private int tphone;         //联系方式
    private String tgrade;      //负责的年级
    private String tschool;     //负责的专业
    private String tinfo;       //简介
}
