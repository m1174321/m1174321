package com.fh.book.book.controller;

import com.fh.book.book.biz.IBookService;
import com.fh.book.book.common.ServerResponse;
import com.fh.book.book.po.Book;
import com.fh.book.book.vo.BookUp;
import com.fh.book.book.vo.BookVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    @Resource(name = "bookService")
    private IBookService bookService;

    @RequestMapping(method = RequestMethod.POST)
    public ServerResponse bookAdd(Book book){
        bookService.bookAdd(book);
        return ServerResponse.success();
    }


    @RequestMapping(method = RequestMethod.GET)
    public Map findBookList(BookVO bookVO){
        Map map = bookService.findBookList(bookVO);
        return map;
    }

    @RequestMapping(value = "{id}", method=RequestMethod.DELETE)
    public ServerResponse deleteBook(@PathVariable("id") int id){
        bookService.deleteBook(id);
        return ServerResponse.success();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ServerResponse findBookById(@PathVariable int id) {
        BookUp book = bookService.findBookById(id);
        return ServerResponse.success(book);
    }




}
