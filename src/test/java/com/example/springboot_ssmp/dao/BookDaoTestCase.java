package com.example.springboot_ssmp.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testAdd(){
        Book book = new Book("计算机11","Java从入门到放弃","Java入门书籍");
        bookDao.insert(book);
//        System.out.println("result:"+result);
        System.out.println("id:"+book.getId());
    }

    @Test
    void testDelete(){
        bookDao.deleteById(1);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(2);
        book.setName("Java编程思想");
        bookDao.updateById(book);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    void testGetPage(){
        IPage<Book> page = new Page(1,2);
        bookDao.selectPage(page,null);
    }

    @Test
    void testGetBy(){
        String name= null;
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<>();
        qw.like(name!= null,Book::getName,name);
        bookDao.selectList(qw);
    }
}
