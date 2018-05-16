package com.hr.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hr.contant.TrainConstants;
import com.hr.entity.Train;
import com.hr.service.TrainService;
import com.hr.vo.DataResult;
import com.hr.vo.LayuiReplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
@Controller
@RequestMapping("/hr/train")
public class TrainController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String add(@Validated Train train, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return DataResult.toJson(false, "信息不全", null);
        }

        train.setCreateTime(new Date());
        try {
            trainService.insert(train);
            return DataResult.toJson(true, "OK", train.getId());
        } catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(false, "添加失败，请重试", null);
        }
    }

    @RequestMapping(value = "/get" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String get(int page,int size){
        Wrapper<Train> wrapper = new EntityWrapper<Train>().orderBy("create_time");
        try {
            Page selectPage = trainService.selectPage(new Page(page, size), wrapper);
            int count = trainService.selectCount(wrapper);
            return LayuiReplay.toJson(true, "OK", count, selectPage.getRecords());
        } catch (Exception e) {
            logger.info("",e);
            return LayuiReplay.toJson(true, "OK", 0,null);
        }
    }

    @RequestMapping(value = "/complete", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String complete(int id, String effect, String summarize) {
        Train train = new Train();
        train.setId(id);
        train.setEducate(TrainConstants.TRAIN_OVER);
        train.setEffect(effect);
        train.setSummarize(summarize);
        train.setEndTime(new Date());
        try {
            trainService.updateById(train);
            return DataResult.toJson(true, "更新成功", null);
        } catch (Exception e) {
            logger.info("更新培训信息",e);
            return DataResult.toJson(false, "更新失败，请重试", null);
        }
    }

    @RequestMapping(value = "/delete" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(Integer id){
        try {
            trainService.deleteById(id);
            return DataResult.toJson(true, "删除成功",null);
        } catch (Exception e) {
            System.out.println(e);
            return DataResult.toJson(false, "删除失败，请重试",null);
        }
    }

}

