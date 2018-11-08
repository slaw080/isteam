package com.bjgoodwill.isteam.common.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ClassName MyMapper
 * @Description 自定义Mapper
 * @Author LI JUN
 * @Date 2018/11/7 10:47
 * @Version 0.0.1
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}