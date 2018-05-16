package com.hr.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hr.contant.TrainConstants;
import com.hr.entity.Train;
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
public class TrainServiceImplTest {

    @Autowired
    private TrainService trainService;

    @Test
    public void test() {
        int page = 1;
        int size = 10;
        Wrapper<Train> wrapper = new EntityWrapper<Train>().orderBy("create_time");
        Page selectPage = trainService.selectPage(new Page(page, size), wrapper);
        int count = trainService.selectCount(wrapper);
        String json = LayuiReplay.toJson(true, "OK", count, selectPage.getRecords());
        System.out.println(json);
    }
    
    @Test
    public void uodate() {
        Train train = new Train();
        train.setId(3);
        train.setEducate(TrainConstants.TRAIN_OVER);
        train.setEffect("暂无");
        train.setSummarize("暂无");

        trainService.updateById(train);

        Train trainDB = trainService.selectById(3);
        System.out.println(trainDB);
    }

}