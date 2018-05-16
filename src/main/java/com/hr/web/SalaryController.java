package com.hr.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hr.entity.Salary;
import com.hr.entity.Train;
import com.hr.service.SalaryService;
import com.hr.vo.DataResult;
import com.hr.vo.LayuiReplay;
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
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    private Logger logger= LoggerFactory.getLogger(getClass());

    /**
     * 查询出人员
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/getSalary",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getSalary(@RequestParam("page")int page,@RequestParam("size")int size){

        Wrapper<Salary> wrapper = new EntityWrapper<Salary>().orderBy("total_salary");
        try {
            Page selectPage = salaryService.selectPage(new Page(page, size), wrapper);
            int count = salaryService.selectCount(wrapper);
            return LayuiReplay.toJson(true, "OK", count, selectPage.getRecords());
        } catch (Exception e) {
            logger.info("",e);
            return DataResult.toJson(true, "OK", null);
        }
    }

    /**
     * 添加薪金
     * @param salary
     * @return
     */
    @RequestMapping(value = "/addSalary" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String addSalary(Salary salary){
        salary.setGrantTime(new Date());
        salary.calTotalSalary();
        logger.info("添加："+salary.toString()+salary.getTotalSalary());

        try {
            salaryService.insert(salary);
            return DataResult.toJson(false, "OK", null);
        } catch (Exception e) {
            logger.info("",e);
            return DataResult.toJson(true, "OK", null);
        }
    }

    /**
     * 删除薪金
     * @param salarys
     * @return
     */
    @RequestMapping(value = "/removeSalary" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String removeSalary(@RequestParam("salarys") String salarys){

        Gson gson=new Gson();
        //将json转换成salarys类型
        Type type = new TypeToken<List<Salary>>() {}.getType();
        List<Salary> rs=gson.fromJson(salarys, type);

        // 取出薪金
        for(Salary s:rs){
            Salary user = salaryService.selectById(s.getId());
            if (user == null) {
                return DataResult.toJson(true,"fail!",null);
            }
            salaryService.deleteById(s.getId());
            logger.info("删除"+s.getName());
        }

        return DataResult.toJson(false,"success!",null);
    }

    /**
     * 编辑薪金
     * @param salary
     * @return
     */
    @RequestMapping(value = "/editSalary" ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String editSalary(@RequestParam("salary")String salary){
        Gson gson=new Gson();
        //将json转换成salarys类型
        Type type = new TypeToken<List<Salary>>() {}.getType();
        List<Salary> rs=gson.fromJson(salary, type);

        // 取出薪金
        for(Salary s:rs){
            Salary sala = salaryService.selectById(s.getId());
            if (sala == null) {
                return DataResult.toJson(true,"fail!",null);
            }
            salaryService.updateById(s);

            logger.info("更新"+s.getName());
        }

        return DataResult.toJson(false,"success!",null);
    }
}

