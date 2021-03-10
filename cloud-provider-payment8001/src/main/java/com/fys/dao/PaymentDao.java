package com.fys.dao;


import com.fys.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 *  Payment表数据库访问层
 */
@Mapper
public interface PaymentDao {

    /**
     * 新增数据
     * @param payment 实例对象
     * @return 影响行数
     */
     int insert(Payment payment);

    /**
     * 通过ID查找单条数据
     * @param id 主键
     * @return 实例对象
     */
     Payment queryById(Long id);


}
