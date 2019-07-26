package com.fh.book.book.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("t_book")
public class Book {

    @TableId(type = IdType.AUTO)
    private int id;
    @TableField("bookName")
    private String bookName;
    @TableField("price")
    private Float price;
    @TableField("createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @TableField("typeId")
    private int typeId;
    @TableField("typeName")
    private String typeName;


}
