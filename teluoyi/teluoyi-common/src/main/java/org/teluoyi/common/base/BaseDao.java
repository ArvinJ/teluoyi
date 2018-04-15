package org.teluoyi.common.base;

import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: BaseDao
 * @Description: TODO(BaseDao 用于操作数据库)
 * @author wenjin.zhu
 * @date 2018年4月14日
 *
 * @param <T>
 */
public interface BaseDao<T> {
	T queryObject(Integer id);

	List<T> selectAllObject();

	List<T> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(T t);

	void update(T t);

	void delete(Integer id);

	void deleteBatch(Integer[] ids);
}
