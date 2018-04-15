package org.teluoyi.dao;

import org.apache.ibatis.annotations.Mapper;
import org.teluoyi.common.base.BaseDao;
import org.teluoyi.entity.UserEntity;

@Mapper
public interface UserDao extends BaseDao<UserEntity> {
	
}