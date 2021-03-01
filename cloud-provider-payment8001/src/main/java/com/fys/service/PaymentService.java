package com.fys.service;


import com.fys.entities.Payment;

/**
 * Payment表服务接口
 */
public interface PaymentService {

    /**
     * 新增数据
     * @param payment 实例对象
     * @return 影响行数
     */
    Payment insert(Payment payment);

    /**
     * 通过ID查找单条数据
     * @param id 主键
     * @return 实例对象
     */
    Payment queryById(Long id);
}
