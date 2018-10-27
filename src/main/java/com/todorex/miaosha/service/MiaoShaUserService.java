package com.todorex.miaosha.service;

import com.todorex.miaosha.domain.MiaoShaUser;
import com.todorex.miaosha.result.CodeMsg;
import com.todorex.miaosha.vo.LoginVo;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author rex
 * 2018/10/25
 */
public interface MiaoShaUserService {

    /**
     * 根据用户ID获取用户
     * @param id
     * @return
     */
    public MiaoShaUser getById(long id);

    /**
     * 校验登录
     * @param response
     * @param loginVo
     * @return
     */
    public boolean login(HttpServletResponse response, LoginVo loginVo);

    /**
     * 根据token获得用户
     * @param response
     * @param token
     * @return
     */
    public MiaoShaUser getByToken(HttpServletResponse response, String token);
}
