package com.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Result<E> implements Serializable {

    User data;

    List<E> dataList;

    Appointment appointment;

    Teacher teacher;

    public Result(User data) {
        this.data = data;
    }

    public Result(List<E> dataList){
        this.dataList = dataList;
    }

    public Result(Appointment appointment){
        this.appointment = appointment;
    }

    public Result(Teacher teacher){
        this.teacher = teacher;
    }

}
