package com.example.entity.car;

import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 消息包编号表
 * </p>
 */
@Data
public class MessagePackageNo {

    private static final long serialVersionUID = 1L;

    /**
     * 消息包编号
     */
	private Integer no;
    /**
     * 创建时间
     */
	private Date createTime;
}
