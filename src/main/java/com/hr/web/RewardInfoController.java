package com.hr.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hr.entity.RewardInfo;
import com.hr.service.RewardInfoService;
import com.hr.vo.DataResult;
import com.hr.vo.LayuiReplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
@Controller
@RequestMapping("/hr/rewardInfo")
public class RewardInfoController {

    @Autowired
    private RewardInfoService rewardInfoService;

    @RequestMapping(value = "/add" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String add(@Validated RewardInfo rewardInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return DataResult.toJson(false, "请先填写全部信息", null);
        }

        rewardInfo.setCareteTime(new Date());
        try {
            rewardInfoService.insert(rewardInfo);
            return DataResult.toJson(true, "添加成功", null);
        } catch (Exception e) {
            System.out.println(e);
            return DataResult.toJson(false, "添加失败", null);
        }
    }

    @RequestMapping(value = "/get" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String get(int page,int size){
        Wrapper<RewardInfo> wrapper = new EntityWrapper<RewardInfo>().orderBy("create_time");
        try {
            Page<RewardInfo> rewardInfoPage = rewardInfoService.selectPage(new Page<>(page, size), wrapper);
            int count = rewardInfoService.selectCount(wrapper);
            return LayuiReplay.toJson(true, "OK", count, rewardInfoPage.getRecords());
        } catch (Exception e) {
            System.out.println(e);
            return LayuiReplay.toJson(false, "获取列表少失败，请重试", 0, null);
        }
    }

    @RequestMapping(value = "/delete" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(Integer id){
        System.out.println(id);
        try {
            rewardInfoService.deleteById(id);
            return DataResult.toJson(true, "删除成功", null);
        } catch (Exception e) {
            System.out.println(e);
            return DataResult.toJson(false, "删除失败，请重试", null);
        }
    }

}

