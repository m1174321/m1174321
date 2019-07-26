package com.fh.book.book.vo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.book.book.po.Book;

public class bookParam {


    public static Wrapper<Book> wrapper(BookVO bookVO){
        QueryWrapper<Book> bookQueryWrapper = new QueryWrapper<Book>();
        if (bookVO.getBookName()!=null && !bookVO.getBookName().equals("")){
            bookQueryWrapper.like("bookName",bookVO.getBookName());
        }
        return bookQueryWrapper;
    }

}
