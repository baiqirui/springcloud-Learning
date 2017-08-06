package com.bqr.domain;
import lombok.Data;


@Data
public class Person
{
    // ID
    private Integer personId;
    
    // 姓名
    private String personName;
    
    // 年龄
    private String personAge;
    
    // 性别
    private String personSex;
    
}
