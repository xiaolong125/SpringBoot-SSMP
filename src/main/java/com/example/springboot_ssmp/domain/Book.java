package com.example.springboot_ssmp.domain;

import lombok.Data;

//@Data 注解在编译器设置对应的get/set、toString、HashCode、equals等方法
@Data
public class Book {
    private int id;
    private String type;
    private String name;
    private String description;

    public Book(){

    }

    public Book(String type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }
}
