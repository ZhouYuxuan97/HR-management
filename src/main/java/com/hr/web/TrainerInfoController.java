package com.hr.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hr.entity.TrainerInfo;
import com.hr.service.TrainerInfoService;
import com.hr.vo.DataResult;
import com.hr.vo.LayuiReplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 培训学员信息 前端控制器
 * </p>
 *
 * @author finalcola
 * @since 2017-12-29
 */
@Controller
@RequestMapping("/hr/trainerInfo")
public class TrainerInfoController {

    @Autowired
    private TrainerInfoService trainerInfoService;

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String add(@Validated TrainerInfo trainerInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return DataResult.toJson(false, "填写的信息不完整", null);
        }

        try {
            trainerInfoService.insert(trainerInfo);
            return DataResult.toJson(true, "添加成功", null);
        } catch (Exception e) {
            System.out.println(e);
            return DataResult.toJson(false, trainerInfo.getUsername()+"--添加失败，请重试", null);
        }
    }

    @RequestMapping(value = "/list" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String list(int trainId,int page,int size){
        Wrapper<TrainerInfo> wrapper = new EntityWrapper<TrainerInfo>().where("train_id={0}", trainId);
        try {
            Page<TrainerInfo> trainerInfoPage = trainerInfoService.selectPage(new Page<>(page, size), wrapper);
            int selectCount = trainerInfoService.selectCount(wrapper);
            return LayuiReplay.toJson(true, "OK", selectCount, trainerInfoPage.getRecords());
        } catch (Exception e) {
            System.out.println(e);
            return LayuiReplay.toJson(false, "获取列表失败，请重试", 0, null);
        }
    }

}

