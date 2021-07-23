package com.yu.springcloud.service.impl;

import com.yu.springcloud.dao.PaymentDao;
import com.yu.springcloud.entity.Payment;
import com.yu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Payment)表服务实现类
 *
 * @author yu
 * @since 2020-11-15 17:34:45
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Payment selectById(Long id) {
        return paymentDao.selectById(id);
    }

    /**
     * 查询多条数据
     *
     * @param payment 实例对象
     * @return 对象列表
     */
    @Override
    public List<Payment> selectList(Payment payment) {
        return paymentDao.selectList(payment);
    }

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Long id) {
        return paymentDao.deleteById(id);
    }

    /**
     * 查询数量
     *
     * @param payment 实例对象
     * @return 总数量
     */
    @Override
    public int getTotal(Payment payment) {
        return paymentDao.getTotal(payment);
    }
}