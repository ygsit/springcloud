package com.yu.springcloud.service;

import com.yu.springcloud.entity.Payment;

import java.util.List;

/**
 * (Payment)表服务接口
 *
 * @author yu
 * @since 2020-11-15 17:26:03
 */
public interface PaymentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment selectById(Long id);

    /**
     * 查询多条数据
     *
     * @param payment 实例对象
     * @return 对象列表
     */
    List<Payment> selectList(Payment payment);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    int insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     */
    int update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(Long id);

    /**
     * 查询数量
     *
     * @param payment 实例对象
     * @return 总数量
     */
    int getTotal(Payment payment);

}