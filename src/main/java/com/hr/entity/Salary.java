package com.hr.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
public class Salary extends Model<Salary> {

    private static final long serialVersionUID = 1L;

	private Integer id;
    /**
     * 员工姓名
     */
	private String name;
	private Integer basic;
	private Integer eat;
	private Integer house;
	@TableField("grant_time")
	private Date grantTime;
	private Integer scot;
	private Integer duty;
	private Integer punishment;
	private Integer other;
	@TableField("total_salary")
	private Integer totalSalary;


	public Integer getId() {
		return id;
	}

	public Salary setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Salary setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getBasic() {
		return basic;
	}

	public Salary setBasic(Integer basic) {
		this.basic = basic;
		return this;
	}

	public Integer getEat() {
		return eat;
	}

	public Salary setEat(Integer eat) {
		this.eat = eat;
		return this;
	}

	public Integer getHouse() {
		return house;
	}

	public Salary setHouse(Integer house) {
		this.house = house;
		return this;
	}

	public Date getGrantTime() {
		return grantTime;
	}

	public Salary setGrantTime(Date grantTime) {
		this.grantTime = grantTime;
		return this;
	}

	public Integer getScot() {
		return scot;
	}

	public Salary setScot(Integer scot) {
		this.scot = scot;
		return this;
	}

	public Integer getDuty() {
		return duty;
	}

	public Salary setDuty(Integer duty) {
		this.duty = duty;
		return this;
	}

	public Integer getPunishment() {
		return punishment;
	}

	public Salary setPunishment(Integer punishment) {
		this.punishment = punishment;
		return this;
	}

	public Integer getOther() {
		return other;
	}

	public Salary setOther(Integer other) {
		this.other = other;
		return this;
	}

	public Integer getTotalSalary() {
		return totalSalary;
	}

	public Salary setTotalSalary(Integer totalSalary) {
		this.totalSalary = totalSalary;
		return this;
	}

	public void calTotalSalary(){
		this.totalSalary=this.basic+this.eat+this.house+this.scot-this.duty-this.punishment+this.other;
	}
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Salary{" +
			", id=" + id +
			", name=" + name +
			", basic=" + basic +
			", eat=" + eat +
			", house=" + house +
			", grantTime=" + grantTime +
			", scot=" + scot +
			", duty=" + duty +
			", punishment=" + punishment +
			", other=" + other +
			", totalSalary=" + totalSalary +
			"}";
	}
}
