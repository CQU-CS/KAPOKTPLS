package com.cqu.kapok.kapoktpls.utils;

import com.cqu.kapok.kapoktpls.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MenuUtil
 * Description:
 * date: 2022/6/20 16:11
 *
 * @author 肖鸿亮
 * @since JDK 1.8
 */
public class MenuUtil {

    /**
     * 根据权限获取菜单
     * @param
     * @return
     */
    public static List<MenuVo> getMenuVoByAuthorityId(String accountType){
        //管理员可以看到所有
        //普通用户不可以查看用户管理页面
        List<MenuVo> menuVo = new ArrayList<>();//返回的主要对象
        //首页
        MenuVo mainPage = new MenuVo();
        mainPage.setId("1");
        mainPage.setPath("/mainPage");
        mainPage.setTitle("首页");
        mainPage.setIcon("el-icon-s-grid");
        menuVo.add(mainPage);//添加首页菜单
        //系统管理
        MenuVo managerPage = new MenuVo();
        managerPage.setId("2");
        managerPage.setPath("/managerPage");
        managerPage.setTitle("系统管理");
        managerPage.setIcon("el-icon-s-tools");
        menuVo.add(managerPage);//添加系统管理菜单
        //系统管理的子菜单
        ArrayList<MenuVo> managerChildren = new ArrayList<>();
        managerPage.setChildren(managerChildren);
        //文档管理
        MenuVo docManager = new MenuVo();
        docManager.setId("3");
        docManager.setPath("/docManager");
        docManager.setTitle("文档管理");
        docManager.setIcon("el-icon-document");
        //将文档管理放入系统管理的children里
        managerChildren.add(docManager);
        if (accountType.equals("root")){//用户是管理员
            //放入用户管理
            MenuVo userManager = new MenuVo();
            userManager.setId("4");
            userManager.setPath("/userManager");
            userManager.setTitle("用户管理");
            userManager.setIcon("el-icon-user-solid");
            //将用户管理菜单 放入系统管理子菜单
            managerChildren.add(userManager);
        }
        return menuVo;
    }
}
