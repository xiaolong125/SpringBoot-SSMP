package com.example.springboot_ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

//    @Select("select * from tb1_book where id = #{id}")
//    Book getById(int id);

}
