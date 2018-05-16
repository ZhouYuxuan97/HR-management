package com.hr.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
@TableName("user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String username;
	private String password;
	private String sex;
	private Date birthday;
	@TableField("create_time")
	private Date createTime;
	@TableField("is_admin")
	private String isAdmin;
    /**
     * 人员简介
     */
	private String content;


	public Integer getId() {
		return id;
	}

	public UserInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public UserInfo setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserInfo setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public UserInfo setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public Date getBirthday() {
		return birthday;
	}

	public UserInfo setBirthday(Date birthday) {
		this.birthday = birthday;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public UserInfo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public UserInfo setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	public String getContent() {
		return content;
	}

	public UserInfo setContent(String content) {
		this.content = content;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
			", id=" + id +
			", username=" + username +
			", password=" + password +
			", sex=" + sex +
			", birthday=" + birthday +
			", createTime=" + createTime +
			", isAdmin=" + isAdmin +
			", content=" + content +
			"}";
	}
}
