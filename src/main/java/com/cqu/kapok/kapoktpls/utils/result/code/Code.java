package com.cqu.kapok.kapoktpls.utils.result.code;

public interface Code {
	// 成功
	int SUCCESS  = Errs.put(20000, "成功");
	// 操作有误
	int ERROR	 = Errs.put(-1, "操作有误");
	// 未知错误
	int LOGIN_OUT	 = Errs.put(-2, "登录失效");
	// 账号或密码错误
	int LOGIN_NOT_EXIST	 = Errs.put(-3, "账号或密码错误");
	//登录成功
	int LOGIN_SUCCESS  = Errs.put(201, "登录成功");
	//地址不存在
	int ADDRESS_NOT_EXIST = Errs.put(-4, "地址不存在");
	//删除地址出错
	int ADDRESS_DELETE_ERROR = Errs.put(-5,"操作有误，删除的地址被其他表格使用");
	//公司删除出错
	int COMPANY_DELETE_ERROR = Errs.put(-6,"操作有误，删除的公司被其他表格使用");
	//广告删除出错
	int ADVERTISEMENT_DELETE_ERROR = Errs.put(-7,"操作有误，删除广告出现异常");
	//建筑删除出错
	int BUILDING_DELETE_ERROR = Errs.put(-8,"操作有误，删除的建筑被其他表格使用");
	//建筑租赁删除出错
	int BUILDINGRENT_DELETE_ERROR = Errs.put(-9,"操作有误，删除建筑租赁出现异常");
}
