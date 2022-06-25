package com.cqu.kapok.kapoktpls.vo;

import lombok.Data;

import java.util.List;

/**
 * ClassName: MenuVo
 * Description:
 * date: 2022/6/20 16:04
 *
 * @author 肖鸿亮
 * @since JDK 1.8
 */
@Data
public class MenuVo {
    private String id;//菜单id
    private String path;//页面路径
    private String title;//菜单名称
    private String icon;//菜单图标
    private List<MenuVo> children;//子菜单
}
