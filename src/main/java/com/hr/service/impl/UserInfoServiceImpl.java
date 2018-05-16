package com.hr.service.impl;

import com.hr.entity.UserInfo;
import com.hr.mapper.UserInfoMapper;
import com.hr.service.UserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    public UserInfo getUserInfo(String username, String password) {

        UserInfo userInfo = baseMapper.getUserInfo(username);
        if(password.equals(userInfo.getPassword())) {
            return userInfo;
        } else {
            return null;
        }

    }
}
