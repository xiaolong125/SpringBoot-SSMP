package com.example.springboot_ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot_ssmp.dao.BookDao;
import com.example.springboot_ssmp.domain.Book;
import com.example.springboot_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IBookServiceImpl2 extends ServiceImpl<BookDao,Book> implements IBookService {

    @Autowired
    BookDao bookDao;

    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean delete(int id) {
        return bookDao.deleteById(id) >0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public IPage<Book> getPage(int pageIndex,int pageSize) {
        IPage<Book> page = new Page<>(pageIndex,pageSize);
        return bookDao.selectPage(page,null);
    }

//    @Autowired
//    BookDao bookDao;
//
//    @Override
//    public boolean save(Book book) {
//        return bookDao.insert(book) > 0;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return bookDao.deleteById(id) >0;
//    }
//
//    @Override
//    public boolean update(Book book) {
//        return bookDao.updateById(book)>0;
//    }
//
//    @Override
//    public Book getById(int id) {
//        return bookDao.selectById(id);
//    }
//
//    @Override
//    public List<Book> getAll() {
//        return bookDao.selectList(null);
//    }
//
//    @Override
//    public IPage<Book> getByPage(int currentPage, int pageSize) {
//        IPage<Book> page = new Page<>(currentPage,pageSize);
//        return bookDao.selectPage(page,null);
//    }
}
