package com.hr.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
public class Train extends Model<Train> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 培训名称
     */
    @NotNull
	private String name;
    /**
     * 培训目的
     */
    @NotNull
	private String prupose;
	@NotNull
	@TableField("begin_time")
	private Date beginTime;
	@NotNull
	@TableField("end_time")
	private Date endTime;
    /**
     * 培训材料
     */
	@NotNull
	private String datum;
    /**
     * 培训老师
     */
	@NotNull
	private String teacher;
	@NotNull
	private String student;
	@TableField("create_time")
	private Date createTime;
    /**
     * 培训是否完成
     */
	private String educate;
    /**
     * 培训效果
     */
	private String effect;
    /**
     * 培训总结
     */
	private String summarize;


	public Integer getId() {
		return id;
	}

	public Train setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Train setName(String name) {
		this.name = name;
		return this;
	}

	public String getPrupose() {
		return prupose;
	}

	public Train setPrupose(String prupose) {
		this.prupose = prupose;
		return this;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public Train setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
		return this;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Train setEndTime(Date endTime) {
		this.endTime = endTime;
		return this;
	}

	public String getDatum() {
		return datum;
	}

	public Train setDatum(String datum) {
		this.datum = datum;
		return this;
	}

	public String getTeacher() {
		return teacher;
	}

	public Train setTeacher(String teacher) {
		this.teacher = teacher;
		return this;
	}

	public String getStudent() {
		return student;
	}

	public Train setStudent(String student) {
		this.student = student;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Train setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public String getEducate() {
		return educate;
	}

	public Train setEducate(String educate) {
		this.educate = educate;
		return this;
	}

	public String getEffect() {
		return effect;
	}

	public Train setEffect(String effect) {
		this.effect = effect;
		return this;
	}

	public String getSummarize() {
		return summarize;
	}

	public Train setSummarize(String summarize) {
		this.summarize = summarize;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Train{" +
			", id=" + id +
			", name=" + name +
			", prupose=" + prupose +
			", beginTime=" + beginTime +
			", endTime=" + endTime +
			", datum=" + datum +
			", teacher=" + teacher +
			", student=" + student +
			", createTime=" + createTime +
			", educate=" + educate +
			", effect=" + effect +
			", summarize=" + summarize +
			"}";
	}
}
