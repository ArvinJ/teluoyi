package org.teluoyi.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author wenjin.zhu
 * @email 15156980156@163.com
 * @date 2018-04-14 16:47:01
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主索引id
	private Integer id;
	//用户名
	private String username;
	//密码
	private String password;
	//创建时间
	private Date createtime;
	//更新时间
	private String updatetime;
	//是否可用，00可用
	private String status;

	/**
	 * 设置：主索引id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主索引id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * 获取：更新时间
	 */
	public String getUpdatetime() {
		return updatetime;
	}
	/**
	 * 设置：是否可用，00可用
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：是否可用，00可用
	 */
	public String getStatus() {
		return status;
	}
	
	public UserEntity() {
		
	}
	public UserEntity(String username, String password, String updatetime, String status) {
		this.username = username;
		this.password = password;
		this.updatetime = updatetime;
		this.status = status;
	}

}
