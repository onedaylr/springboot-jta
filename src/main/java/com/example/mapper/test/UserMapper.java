package com.example.mapper.test;

import com.example.entity.test.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

/**
 * <p>
  *  Mapper 接口
 * </p>
 */
@Repository
public interface UserMapper {

    @Insert("INSERT INTO `tb_user` (`id`, `name`, `age`, `create_time`) VALUES (NULL, #{user.name}, #{user.age}, NOW())")
    void insert(@Param("user") User user);
    @Select("select * from tb_user where name =#{name}")
    User findByName(@Param("name") String name);
}