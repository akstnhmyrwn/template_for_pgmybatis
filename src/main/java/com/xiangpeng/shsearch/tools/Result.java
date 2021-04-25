package com.xiangpeng.shsearch.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private T data;
    private String msg;
    private short status;

    /*public static Result success(Object data){
        return data instanceof Collection?new Result(JSONArray.toJSONString(data),"请求成功",ResultState.success):new Result(JSON.toJSONString(data),"请求成功",ResultState.success);
    }*/
    public static <T> Result<T> success(T data){
        return new Result<T>(data,"请求成功",ResultState.success);
    }
    public static class ResultState{

        public static final short success = 1;
        public static final short fail = -1;
    }
}
