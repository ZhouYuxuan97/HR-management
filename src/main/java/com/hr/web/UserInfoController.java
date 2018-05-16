package com.hr.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hr.entity.UserInfo;
import com.hr.service.UserInfoService;
import com.hr.vo.DataResult;
import com.hr.vo.LayuiReplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
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
@RequestMapping("/hr/userInfo")
public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加人员信息
     *
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String add(UserInfo userInfo) {

        System.out.print("------------*****************--------------");
        userInfo.setCreateTime(new Date());
        try {
            userInfoService.insert(userInfo);
            return DataResult.toJson(true, "OK", null);
        }
        catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(true, "fail", null);
        }
    }

    /**
     *  获取所有人员的信息
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/getAll", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String getAll(int page, int size) {

        Wrapper<UserInfo> wrapper = new EntityWrapper<UserInfo>().orderBy("create_time");
        try {
            Page selectPage = userInfoService.selectPage(new Page(page, size), wrapper);
            int count = userInfoService.selectCount(wrapper);
            return LayuiReplay.toJson(true, "OK", count, selectPage.getRecords());
        } catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(true, "fail", null);
        }
    }

    /**
     * 删除人员信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(HttpServletRequest request) {

        String id = request.getParameter("id");
        try {
            userInfoService.deleteById(Integer.parseInt(id));
            return DataResult.toJson(true, "OK", null);
        }
        catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(true, "Fail", null);
        }
    }

    /**
     * 根据id查询信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value="/get", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String get(HttpServletRequest request) {

        String id = request.getParameter("id");

        try {
            UserInfo userInfo = userInfoService.selectById(id);
            return DataResult.toJson(true, "OK", userInfo);
        } catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(true, "Fail", null);
        }
    }

    @RequestMapping(value="/edit", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String edit(UserInfo userInfo, HttpServletRequest request) {

        try {

            userInfoService.updateById(userInfo);
            return DataResult.toJson(true, "OK", userInfo);
        } catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(true, "Fail", null);
        }
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value="/login", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String login(String username, String password, HttpSession session) {

        try {
            UserInfo userInfo = userInfoService.getUserInfo(username, password);
            if (userInfo == null) {
                return DataResult.toJson(false, "Fail", null);
            } else {
                session.setAttribute("userInfo", userInfo);
                return DataResult.toJson(true, "OK", userInfo);
            }

        } catch (Exception e) {
            logger.info("", e);
            return DataResult.toJson(true, "Fail", null);
        }
    }

}

