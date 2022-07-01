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
	// 汽车删除出错
	int TRUCK_DELETE_ERROR = Errs.put(-5,"操作有误，删除的汽车被其他表格使用");
	// 汽车维修记录删除出错
	int TRUCK_REPAIR_RECORD_ERROR = Errs.put(-5,"操作有误，删除的汽车维修记录被其他表格使用");
	// 运输任务删除出错
	int TRANSPORTATIONtASK_ERROR = Errs.put(-5,"操作有误，删除的运输任务记录被其他表格使用");
	//货物记录删除出错
	int GOODS_DELETE_ERROR = Errs.put(-5,"操作有误，删除的货物被其他表格使用");
	//建筑租赁记录删除出错
	int BUILDINGRENT_DELETE_ERROR = Errs.put(-5,"操作有误，建筑租赁出现异常");
	//广告记录删除出错
	int ADVERTISEMENT_DELETE_ERROR = Errs.put(-5,"操作有误，删除的货物被其他表格使用");
	//建筑记录删除出错
	int BUILDING_DELETE_ERROR = Errs.put(-5,"操作有误，删除的货物被其他表格使用");
	//管理员记录编辑出错
	int ACCOUNTROOT_DELETE_ERROR = Errs.put(-5,"操作有误，该管理员账号不可被编辑");
	//建筑出售记录删除出错
	int BUILDINGSALE_DELETE_ERROR = Errs.put(-5,"操作有误，该管理员账号不可被编辑");
}
