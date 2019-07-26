package com.fh.book.book.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.book.book.po.Book;

public interface IBookMapper extends BaseMapper<Book> {


    void bookAdd(Book book);
}
