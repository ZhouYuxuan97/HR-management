package com.hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hr.entity.Salary;
import com.hr.service.SalaryService;
import com.hr.service.TrainService;
import com.hr.vo.LayuiReplay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SalaryServiceImplTest {

    @Autowired
    private SalaryService salaryService;

    @Test
    public void test() {
        int page = 1;
        int size = 10;
        Wrapper<Salary> wrapper = new EntityWrapper<Salary>().orderBy("total_salary");
        Page selectPage = salaryService.selectPage(new Page(page, size), wrapper);
        int count = salaryService.selectCount(wrapper);
        String json = LayuiReplay.toJson(true, "OK", count, selectPage.getRecords());
        System.out.println(json);
    }
}