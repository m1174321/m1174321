package com.fh.book.book.biz;

import com.fh.book.book.po.Book;
import com.fh.book.book.vo.BookUp;
import com.fh.book.book.vo.BookVO;

import java.util.List;
import java.util.Map;

public interface IBookService {

    void bookAdd(Book book);

    Map findBookList(BookVO bookVO);


    void deleteBook(int id);


    BookUp findBookById(int id);
}
