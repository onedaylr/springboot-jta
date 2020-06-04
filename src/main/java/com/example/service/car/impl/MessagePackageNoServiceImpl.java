package com.example.service.car.impl;

import com.example.entity.car.MessagePackageNo;
import com.example.mapper.car.MessagePackageNoMapper;
import com.example.service.car.MessagePackageNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息包编号表 服务实现类
 * </p>
 */
@Service
public class MessagePackageNoServiceImpl  implements MessagePackageNoService {
	@Autowired
	private MessagePackageNoMapper messagePackageNoMapper;
	
	public void insert(MessagePackageNo messagePackageNo){
		messagePackageNoMapper.insert(messagePackageNo);
	}
}
