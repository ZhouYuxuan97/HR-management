package com.hr.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 培训学员信息
 * </p>
 *
 * @author finalcola
 * @since 2017-12-29
 */
@TableName("trainer_info")
public class TrainerInfo extends Model<TrainerInfo> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	@NotNull
	@Size(min = 1,max = 30)
	private String username;
	@NotNull
	@Size(min = 1,max = 2)
	private String sex;
	@NotNull
	@Size(min = 1,max = 200)
	private String detail;
	@NotNull
	@TableField(value = "train_id")
	private Integer trainId;


	public Integer getId() {
		return id;
	}

	public TrainerInfo setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public String getUsername() {
		return username;
	}

	public TrainerInfo setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getSex() {
		return sex;
	}

	public TrainerInfo setSex(String sex) {
		this.sex = sex;
		return this;
	}

	public String getDetail() {
		return detail;
	}

	public TrainerInfo setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "TrainerInfo{" +
			", id=" + id +
			", username=" + username +
			", sex=" + sex +
			", detail=" + detail +
			"}";
	}
}
