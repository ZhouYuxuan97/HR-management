package com.hr.mapper;

import com.hr.entity.UserInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author finalcola
 * @since 2017-12-28
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo getUserInfo(String username);
}
