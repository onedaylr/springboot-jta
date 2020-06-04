package com.example.entity.test;

import lombok.Data;

import java.util.Date;

/**
 * 用户实体
 */
@Data
public class User{

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 名字
     */
	private String name;
    /**
     * 年龄
     */
	private Integer age;

	private Date createTime;
}
