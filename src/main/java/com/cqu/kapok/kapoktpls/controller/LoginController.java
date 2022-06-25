package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.service.AccountService;
import com.cqu.kapok.kapoktpls.utils.MenuUtil;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * ClassName: LoginController
 * Description:
 * date: 2022/6/18 16:45
 *
 * @author 肖鸿亮
 * @since JDK 1.8
 */
@RestController
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
}
