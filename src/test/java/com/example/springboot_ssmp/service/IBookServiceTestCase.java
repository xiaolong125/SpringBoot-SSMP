package com.example.springboot_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 业务层的方法都要写测试用例
 */
@SpringBootTest
public class IBookServiceTestCase {

    @Autowired
    IBookService IBookService;


    @Test
    public void save() {
        Book book = new Book("医学","妇产科","妇产科书籍");
        boolean result = IBookService.insert(book);
        if (result){
            System.out.println(book);
        }else {
            System.out.println("保存失败");
        }
    }

    @Test
    public void delete() {
        IBookService.delete(2);
    }

    @Test
    public void update() {
        Book book = new Book();
        book.setId(4);
        book.setName("Android第一行代码");
        IBookService.update(book);
    }

    @Test
    void getById(){
        System.out.println(IBookService.getById(1));
    }

    @Test
    public void getAll() {
        System.out.println(IBookService.list());
    }

    @Test
    public void getByPage() {
        IPage<Book> page = new Page<>(2,3);
        System.out.println(IBookService.page(page));
    }
}
