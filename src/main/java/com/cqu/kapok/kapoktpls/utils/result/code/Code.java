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
	int COMPANY_DELETE_ERROR = Errs.put(-5,"操作有误，删除的公司被其他表格使用");
}
