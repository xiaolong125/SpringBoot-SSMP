package com.example.springboot_ssmp.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntry {

    private int code;

    private String message;

    private Object data;

    public static ResponseEntry of(int code, String message,Object data){
        return new ResponseEntry(code,message,data);
    }


    public static ResponseEntry success(Object data){
        return new ResponseEntry(0,"success",data);
    }

    public static ResponseEntry failed(Object data){
        return new ResponseEntry(500,"failed",data);
    }
}
