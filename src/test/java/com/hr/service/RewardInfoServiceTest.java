package com.hr.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class RewardInfoServiceTest {

    @Autowired
    private RewardInfoService rewardInfoService;

    @Test
    public void delete() {
        Integer id = 1;
        rewardInfoService.deleteById(id);
    }

}