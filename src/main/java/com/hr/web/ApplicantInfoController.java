package com.hr.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hr.entity.ApplicantInfo;
import com.hr.service.ApplicantInfoService;
import com.hr.vo.DataResult;
import com.hr.vo.LayuiReplay;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
@Controller
@RequestMapping("/applicantInfo")
public class ApplicantInfoController {

    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicantInfoService applicantInfoService;

    /**
     * 查询出应聘人员
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/getApplication",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getApplication(@RequestParam("page")int page, @RequestParam("size")int size){

        Wrapper<ApplicantInfo> wrapper = new EntityWrapper<ApplicantInfo>().orderBy("id");
        try {
            Page selectPage = applicantInfoService.selectPage(new Page(page, size), wrapper);
            int count = applicantInfoService.selectCount(wrapper);
            return LayuiReplay.toJson(true, "OK", count, selectPage.getRecords());
        } catch (Exception e) {
            logger.info("",e);
            return DataResult.toJson(true, "OK", null);
        }
    }

    /**
     * 添加薪金
     * @param applicantInfo
     * @return
     */
    @RequestMapping(value = "/addApplication" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addApplication(ApplicantInfo applicantInfo){
        applicantInfo.setCreateTime(new Date());
        applicantInfo.setIsStore("0");

        logger.info("添加："+applicantInfo.toString());

        try {
            applicantInfoService.insert(applicantInfo);
            return DataResult.toJson(false, "OK", null);
        } catch (Exception e) {
            logger.info("",e);
            return DataResult.toJson(true, "OK", null);
        }
    }

    /**
     * 删除应聘者
     * @param applications
     * @return
     */
    @RequestMapping(value = "/removeApplication" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String removeApplication(@RequestParam("applications") String applications){

        Gson gson=new Gson();
        //将json转换成salarys类型
        Type type = new TypeToken<List<ApplicantInfo>>() {}.getType();
        List<ApplicantInfo> rs=gson.fromJson(applications, type);

        // 取出薪金
        for(ApplicantInfo a:rs){
            ApplicantInfo applic = applicantInfoService.selectById(a.getId());
            if (applic == null) {
                return DataResult.toJson(true,"fail!",null);
            }
            applicantInfoService.deleteById(a.getId());
            logger.info("删除"+a.getName());
        }

        return DataResult.toJson(false,"success!",null);
    }

    /**
     * 编辑应聘者
     * @param application
     * @return
     */
    @RequestMapping(value = "/editApplication" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String editApplication(@RequestParam("application")String application){
        Gson gson=new Gson();
        //将json转换成salarys类型
        Type type = new TypeToken<List<ApplicantInfo>>() {}.getType();
        List<ApplicantInfo> rs=gson.fromJson(application, type);

        // 取出薪金
        for(ApplicantInfo s:rs){
            ApplicantInfo sala = applicantInfoService.selectById(s.getId());
            if (sala == null) {
                return DataResult.toJson(true,"fail!",null);
            }
            applicantInfoService.updateById(s);

            logger.info("更新"+s.getName());
        }

        return DataResult.toJson(false,"success!",null);
    }

}

