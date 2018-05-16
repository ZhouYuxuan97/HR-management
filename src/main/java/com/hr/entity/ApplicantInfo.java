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
@TableName("applicant_info")
public class ApplicantInfo extends Model<ApplicantInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private String sex;
	private Integer age;
    /**
     * 应聘人员职位
     */
	private String job;
    /**
     * 所学专业
     */
	private String major;
    /**
     * 工作经历
     */
	private String experence;
    /**
     * 学历
     */
	@TableField("study_effort")
	private String studyEffort;
	private String school;
	private String phone;
	private String email;
	@TableField("create_time")
	private Date createTime;
    /**
     * 详细经历
     */
	private String content;
    /**
     * 是否入库
     */
	@TableField("is_store")
	private String isStore;


	public Integer getId() {
		return id;
	}

	public ApplicantInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ApplicantInfo setName(String name) {
		this.name = name;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public ApplicantInfo setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public ApplicantInfo setAge(Integer age) {
		this.age = age;
		return this;
	}

	public String getJob() {
		return job;
	}

	public ApplicantInfo setJob(String job) {
		this.job = job;
		return this;
	}

	public String getMajor() {
		return major;
	}

	public ApplicantInfo setMajor(String major) {
		this.major = major;
		return this;
	}

	public String getExperence() {
		return experence;
	}

	public ApplicantInfo setExperence(String experence) {
		this.experence = experence;
		return this;
	}

	public String getStudyEffort() {
		return studyEffort;
	}

	public ApplicantInfo setStudyEffort(String studyEffort) {
		this.studyEffort = studyEffort;
		return this;
	}

	public String getSchool() {
		return school;
	}

	public ApplicantInfo setSchool(String school) {
		this.school = school;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public ApplicantInfo setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ApplicantInfo setEmail(String email) {
		this.email = email;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public ApplicantInfo setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getContent() {
		return content;
	}

	public ApplicantInfo setContent(String content) {
		this.content = content;
		return this;
	}

	public String getIsStore() {
		return isStore;
	}

	public ApplicantInfo setIsStore(String isStore) {
		this.isStore = isStore;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ApplicantInfo{" +
			", id=" + id +
			", name=" + name +
			", sex=" + sex +
			", age=" + age +
			", job=" + job +
			", major=" + major +
			", experence=" + experence +
			", studyEffort=" + studyEffort +
			", school=" + school +
			", phone=" + phone +
			", email=" + email +
			", createTime=" + createTime +
			", content=" + content +
			", isStore=" + isStore +
			"}";
	}
}
