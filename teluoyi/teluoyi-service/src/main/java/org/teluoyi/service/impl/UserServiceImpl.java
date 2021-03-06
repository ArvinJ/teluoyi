package org.teluoyi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.teluoyi.dao.UserDao;
import org.teluoyi.entity.UserEntity;
import org.teluoyi.service.UserService;

import java.util.List;
import java.util.Map;




@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserEntity queryObject(Integer id){
		return userDao.queryObject(id);
	}
	
	@Override
	public List<UserEntity> queryList(Map<String, Object> map){
		return userDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return userDao.queryTotal(map);
	}
	
	@Override
	public void save(UserEntity user){
		userDao.save(user);
	}
	
	@Override
	public void update(UserEntity user){
		userDao.update(user);
	}
	
	@Override
	public void delete(Integer id){
		userDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		userDao.deleteBatch(ids);
	}
	
}
