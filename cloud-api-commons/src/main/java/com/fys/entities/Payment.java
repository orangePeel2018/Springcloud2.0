package com.fys.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 提取的公共类，放到工具模块，别的模块需要使用，只需要引入此模块的依赖
 * Payment实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}
