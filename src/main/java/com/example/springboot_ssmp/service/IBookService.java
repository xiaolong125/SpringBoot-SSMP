package com.example.springboot_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot_ssmp.domain.Book;
import org.springframework.stereotype.Service;

@Service
public interface IBookService extends IService<Book> {

    boolean insert(Book book);

    boolean delete(int id);

    boolean update(Book book);

    IPage<Book> getPage(int pageIndex,int pageSize);

}
