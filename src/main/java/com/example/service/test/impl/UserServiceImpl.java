package com.example.service.test.impl;

import com.example.entity.test.User;
import com.example.mapper.test.UserMapper;
import com.example.service.test.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcj
 * @since 2017-09-27
 */
@Service
public class UserServiceImpl  implements UserService {
	@Autowired
    private UserMapper userMapper;
	
	public void insert(User user){
		userMapper.insert(user);
	}
}
