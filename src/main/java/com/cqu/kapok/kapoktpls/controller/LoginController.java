package com.cqu.kapok.kapoktpls.controller;

import cn.hutool.core.bean.BeanUtil;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.service.AccountService;
import com.cqu.kapok.kapoktpls.utils.JwtUtil;
import com.cqu.kapok.kapoktpls.utils.MenuUtil;
import com.cqu.kapok.kapoktpls.utils.Token;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: LoginController
 * Description:
 * date: 2022/6/18 16:45
 *
 * @author 肖鸿亮
 * @since JDK 1.8
 */
@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private AccountService accountService;

    /**
     * 用户登录
     * @param account
     * @param session
     * @return
     */
    @PostMapping("login")
    public DataResult login(@RequestBody Account account, HttpSession session){
        System.out.println("sessionId = " + session.getId());
        //1.查询用户是否存在
        Account loginAccount = accountService.queryLogin(account);
        if(null == loginAccount){//用户不存在
            return DataResult.errByErrCode(Code.LOGIN_NOT_EXIST);
        }
        //2.封装返回的数据,返回账号, 用户类型
        UserVo userVo = new UserVo();
        userVo.setUserAccount(loginAccount.getAccountAccount());
        //获取用户可见的菜单
        userVo.setUserMenus(MenuUtil.getMenuVoByAuthorityId(loginAccount.getAccountType()));
        //3.将用户数据放入session
        session.setAttribute("userInfo", userVo);
        //4.设置session过期时间
        session.setMaxInactiveInterval(20 * 60);
        return DataResult.successByData(userVo);
    }

    /**
     * 退出登录
     * @return
     */
    @GetMapping("loginOut")
    public DataResult loginOut(HttpSession session){
        session.removeAttribute("userInfo");
        return DataResult.errByErrCode(Code.LOGIN_OUT);
    }

    /**
     * 测试登录
     * @return
     */
    @PostMapping("vue-admin-template/user/login")
    public DataResult testLogin(@RequestBody Account account){
        //验证账号密码

        //生成Token
        Map<String, String> tokenMap = new HashMap<String, String>();
        BeanUtil.copyProperties(account, tokenMap);
        String token = JwtUtil.getToken(tokenMap);
        //保存Token到数据库

        //返回数据
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return DataResult.successByData(map);
    }

    /**
     * 获取用户数据
     * @return
     */
    @PostMapping("/vue-admin-template/user/info")
    public DataResult getUserInfo(@RequestBody Token token){
        System.out.println("tokensss:"+token);
        //验证Token有效性
        if(JwtUtil.verifyToken(token.getToken())){
            //有效，返回name和avator
            Map<String,String> map = new HashMap<>();
            //去数据库找name和avator

            //返回name和avator
            map.put("name","I am name");
            map.put("avator","I am avator");
            return DataResult.successByData(map);
        }else {
            return DataResult.errByErrCode(50008);
        }
    }
}
