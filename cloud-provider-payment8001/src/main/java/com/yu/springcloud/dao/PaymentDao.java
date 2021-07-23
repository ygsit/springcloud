package com.yu.springcloud.dao;

import com.yu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Payment)表数据库访问层
 *
 * @author yu
 * @since 2020-11-15 17:26:02
 */
@Mapper
public interface PaymentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Payment selectById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param payment 实例对象
     * @return 对象列表
     */
    List<Payment> selectList(Payment payment);

    /**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int insert(Payment payment);

    /**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 影响行数
     */
    int update(Payment payment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
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