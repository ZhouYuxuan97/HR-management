package com.hr.service;

import com.hr.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
public interface UserInfoService extends IService<UserInfo> {

    /**
     * 登录业务
     *
     * @param username
     * @param password
     * @return
     */
    UserInfo getUserInfo(String username, String password);
}
