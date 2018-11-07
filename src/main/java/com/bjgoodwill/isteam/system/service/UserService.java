package com.bjgoodwill.isteam.system.service;

import com.bjgoodwill.isteam.common.domain.QueryRequest;
import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.User;
import com.bjgoodwill.isteam.system.domain.UserWithRole;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @ClassName UserService
 * @Description 用户服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
@CacheConfig(cacheNames = "UserService")
public interface UserService extends IService<User> {

	UserWithRole findById(Long userId);

	User findByName(String userName);

	@Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
	List<User> findUserWithDept(User user, QueryRequest request);

	@CacheEvict(key = "#p0", allEntries = true)
	void registUser(User user);

	void updateTheme(String theme, String userName);

	@CacheEvict(allEntries = true)
	void addUser(User user, Long[] roles);

	@CacheEvict(key = "#p0", allEntries = true)
	void updateUser(User user, Long[] roles);

	@CacheEvict(key = "#p0", allEntries = true)
	void deleteUsers(String userIds);

	void updateLoginTime(String userName);

	void updatePassword(String password);

	User findUserProfile(User user);

	void updateUserProfile(User user);
}
