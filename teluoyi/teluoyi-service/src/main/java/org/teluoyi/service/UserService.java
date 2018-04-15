package org.teluoyi.service;


import java.util.List;
import java.util.Map;

import org.teluoyi.entity.UserEntity;

/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-14 16:47:01
 */
public interface UserService {
	
	UserEntity queryObject(Integer id);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
