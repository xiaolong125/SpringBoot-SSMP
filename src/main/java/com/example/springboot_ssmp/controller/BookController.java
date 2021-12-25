package com.example.springboot_ssmp.controller;


import com.example.springboot_ssmp.controller.utils.ResponseEntry;
import com.example.springboot_ssmp.domain.Book;
import com.example.springboot_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/books")
public class BookController {

    @Qualifier("IBookServiceImpl2")
    @Autowired
    IBookService bookService;


    @GetMapping
    public ResponseEntry getAll() {
        return ResponseEntry.of(0, "success", bookService.list());
    }

    @GetMapping({"/{id}"})
    public ResponseEntry getBook(@PathVariable int id) throws IOException {
        //测试失败数据
        if (true){
            throw new IOException();
        }
        return ResponseEntry.success(bookService.getById(id));
    }

    @RequestMapping(path = "insert", method = RequestMethod.POST)
    public ResponseEntry addBook(@RequestBody Book book) {
        boolean result = bookService.save(book);
        if (result) {
            return ResponseEntry.success(book);
        }
        return ResponseEntry.failed(null);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntry deleteBook(@PathVariable int id) {
        return ResponseEntry.success(bookService.delete(id));
    }

    @PostMapping("/update")
    public ResponseEntry updateOrInsert(@RequestBody Book book) {
        boolean result;
        if (book.getId() == 0) {
            result = bookService.insert(book);
        } else {
            result = bookService.update(book);
        }
        if (result) {
            return ResponseEntry.success(book);
        } else {
            return ResponseEntry.failed(null);
        }
    }

    @GetMapping("/page")
    public ResponseEntry getPage(@RequestParam int pageIndex, @RequestParam int pageSize) {
        return ResponseEntry.success(bookService.getPage(pageIndex, pageSize));
    }
}
