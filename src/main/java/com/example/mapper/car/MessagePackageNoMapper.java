package com.example.mapper.car;

import com.example.entity.car.MessagePackageNo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
  * 消息包编号表 Mapper 接口
 * </p>
 */
@Repository
public interface MessagePackageNoMapper {

    /**
     * 保存
     * @param no
     */
    @Insert("INSERT INTO `tb_message_package_no` (`no`, `create_time`) VALUES (#{no.no}, NOW())")
    void insert(@Param("no") MessagePackageNo no);

    @Select("select * from tb_message_package_no where no = #{no}")
    MessagePackageNo findByno(@Param("no") int no);
}