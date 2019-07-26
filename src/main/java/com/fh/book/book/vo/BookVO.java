package com.fh.book.book.vo;

import com.fh.book.book.common.PageBean;
import lombok.Data;

import java.io.Serializable;

@Data
public class BookVO extends PageBean implements Serializable {
    private static final long serialVersionUID = -7625610217249827373L;

    private String bookName;

    private Float minPrice;

    private Float maxPrice;
}
