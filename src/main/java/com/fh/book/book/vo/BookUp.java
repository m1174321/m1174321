package com.fh.book.book.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookUp implements Serializable {

    private int id;

    private String bookName;

    private Float price;

    private String typeName;

}
