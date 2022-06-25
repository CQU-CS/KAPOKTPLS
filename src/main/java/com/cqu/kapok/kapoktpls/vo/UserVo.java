package com.cqu.kapok.kapoktpls.vo;

import lombok.Data;

import java.util.List;

/**
 * ClassName: UserVo
 * Description:
 * date: 2022/6/20 10:34
 *
 * @author 肖鸿亮
 * @since JDK 1.8
 */
@Data
public class UserVo {
    //用户账号
    private String userAccount;
    //用户类型
    private String authorityName;
    //用户菜单
    private List<MenuVo> userMenus;
}
