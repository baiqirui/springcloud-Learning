package com.bqr.domain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
public class Employee
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
