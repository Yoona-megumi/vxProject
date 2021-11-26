package com.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Result<E> implements Serializable {

    List<E> dataList;

    public Result(List<E> dataList){
        this.dataList = dataList;
    }

}
