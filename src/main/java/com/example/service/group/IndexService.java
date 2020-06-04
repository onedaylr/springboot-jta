package com.example.service.group;


import com.example.entity.car.MessagePackageNo;
import com.example.entity.test.User;
import com.example.service.car.MessagePackageNoService;
import com.example.service.test.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Project: design-pattern
 * @Package: com.lcj.service.impl
 * @Author: Administrator
 * @Description: TODO
 * @Version: 1.0
 * @Datetime: 2017/9/27 17:35
 */
@Service
public class IndexService {
    @Autowired
    private MessagePackageNoService messagePackageNoService;

    @Autowired
    private UserService userService;

    /**
     * 保存数据
     *
     * @param messagePackageNo
     * @param user
     */
    @Transactional
    public void save(MessagePackageNo messagePackageNo, User user , int index) {
        messagePackageNoService.insert(messagePackageNo);
        userService.insert(user);
        int i = 4 / index; // 除0异常,测试事务
    }

    /**
     * @method: findByNo
     * @param: [no]
     * @description: 根据no查询
     * @author: Administrator
     * @date: 2017/9/28
     * @time: 13:21
     * @return: com.lcj.web.entity.car.MessagePackageNo
     */
    public MessagePackageNo findByNo(int no) {
        return new MessagePackageNo();
    }
}
