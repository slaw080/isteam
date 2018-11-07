package com.bjgoodwill.isteam.common.service;

import java.util.List;

/**
 * @ClassName IService
 * @Description 各模块服务基类
 * @Author LI JUN
 * @Date 2018/11/7 11:15
 * @Version 0.0.1
 */
public interface IService<T> {
	
	List<T> selectAll();

	T selectByKey(Object key);

	int save(T entity);

	int delete(Object key);

	int batchDelete(List<String> list, String property, Class<T> clazz);

	int updateAll(T entity);

	int updateNotNull(T entity);

	List<T> selectByExample(Object example);
}
