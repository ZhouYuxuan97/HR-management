package com.hr.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
@TableName("reward__info")
public class RewardInfo extends Model<RewardInfo> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 被奖励人姓名
     */
    @NotNull
	@Size(min = 1,max = 20)
	private String name;
    /**
     * 奖惩原因
     */
    @NotNull
	@Size(min = 1,max = 20)
	private String reason;
    /**
     * 奖惩说明
     */
	@NotNull
	@Size(min = 1,max = 200)
	private String explain;
	@TableField("create_time")
	private Date careteTime;

	public Integer getId() {
		return id;
	}

	public RewardInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public RewardInfo setName(String name) {
		this.name = name;
		return this;
	}

	public String getReason() {
		return reason;
	}

	public RewardInfo setReason(String reason) {
		this.reason = reason;
		return this;
	}

	public String getExplain() {
		return explain;
	}

	public RewardInfo setExplain(String explain) {
		this.explain = explain;
		return this;
	}

	public Date getCareteTime() {
		return careteTime;
	}

	public RewardInfo setCareteTime(Date careteTime) {
		this.careteTime = careteTime;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "RewardInfo{" +
			", id=" + id +
			", name=" + name +
			", reason=" + reason +
			", explain=" + explain +
			", careteTime=" + careteTime +
			"}";
	}
}
