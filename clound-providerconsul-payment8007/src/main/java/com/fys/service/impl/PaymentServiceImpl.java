package com.fys.service.impl;


import com.fys.dao.PaymentDao;
import com.fys.entities.Payment;
import com.fys.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Payment表服务实现类
 */
@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    /**
     * 新增数据
     * @param payment 实例对象
     * @return 影响行数
     */
    @Override
    public Payment insert(Payment payment) {
       this.paymentDao.insert(payment);
       return payment;
    }

    /**
     * 通过ID查找单条数据
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment queryById(Long id) {
       return this.paymentDao.queryById(id);
    }
}
