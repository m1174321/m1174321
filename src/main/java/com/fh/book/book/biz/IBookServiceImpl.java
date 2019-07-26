package com.fh.book.book.biz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.book.book.mapper.IBookMapper;
import com.fh.book.book.po.Book;
import com.fh.book.book.util.DateUtils;
import com.fh.book.book.vo.BookUp;
import com.fh.book.book.vo.BookVO;
import com.fh.book.book.vo.bookParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bookService")
public class IBookServiceImpl implements IBookService {

    @Autowired
    private IBookMapper bookMapper;

    public void bookAdd(Book book) {
        bookMapper.bookAdd(book);
        /*bookMapper.insert(book);*/
    }


    public Map findBookList(BookVO bookVO) {
        //定义一个list是为了对后台接收过来的时间做格式处理
        List<Map<String,Object>> listMap = new ArrayList<>();
        Wrapper<Book> wrapper = bookParam.wrapper(bookVO);
        IPage<Book> bookIPage = bookMapper.selectPage(new Page<Book>(bookVO.getStart(), bookVO.getLength()), wrapper);
        List<Book> records = bookIPage.getRecords();
        long count =records.stream().count();
        List<Map> list = initData(records);
        transitionDate(listMap, records);
        Map<String, Object> map = buildData(bookVO, (int)count,list);
        return map;
    }

    @Override
    public void deleteBook(int id) {
        bookMapper.deleteById(id);
    }

    @Override
    public BookUp findBookById(int id) {
        Book book = this.bookMapper.selectById(id);
        BookUp bv = getBookVo(book);
        return  bv;
    }

    private BookUp getBookVo(Book book) {
        BookUp bv=new BookUp();
        bv.setId(book.getId());
        bv.setBookName(book.getBookName());
        bv.setPrice(book.getPrice());
        bv.setTypeName(book.getTypeName());
        return bv;
    }


    private void transitionDate(List<Map<String, Object>> listMap, List<Book> records) {
        for (Book book : records) {
            Map<String,Object> map = new HashMap<>();
            //前台需要的属性
            map.put("id",book.getId());
            map.put("bookName",book.getBookName());
            map.put("price", book.getPrice());
            map.put("createDate", DateUtils.dateFormatting(book.getCreateTime(),DateUtils.D_Y_M));
            map.put("typeId",book.getTypeId());
            map.put("typeName",book.getTypeName());
            map.put("createTime",book.getCreateTime());
            listMap.add(map);
        }
    }

    private Map<String, Object> buildData(BookVO bookVO, Integer count, List<Map> list) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("draw",bookVO.getDraw());
        map.put("recordsFiltered", count);
        map.put("recordsTotal", count);
        map.put("data",list);
        return map;
    }

    private List<Map> initData(List<Book> records) {
        List<Map> mapList = new ArrayList<Map>();
        for (Book book : records) {
            Map map = new HashMap();
            map.put("id",book.getId());
            map.put("bookName",book.getBookName());
            map.put("price",book.getPrice());
            map.put("typeId",book.getTypeId());
            map.put("typeName",book.getTypeName());
            map.put("createTime",book.getCreateTime());
            mapList.add(map);
        }
        return mapList;
    }


}
