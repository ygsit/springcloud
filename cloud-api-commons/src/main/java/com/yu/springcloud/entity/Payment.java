package com.yu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author yu
 * @since 2020-11-15 18:04:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 458296621954036209L;
    /**
     * id
     */
    private Long id;
    /**
     * 流水号
     */
    private String serial;

}