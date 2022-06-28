package com.cqu.kapok.kapoktpls.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.service.AccountService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Account)表控制层
 *
 * @author makejava
 * @since 2022-06-27 22:23:22
 */
@RestController
@RequestMapping("account")
public class AccountController {
    /**
     * 服务对象
     */
    @Resource
    private AccountService accountService;

    /**
     * 分页查询
     *
     * @param account 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public DataResult<Page<Account>> queryByPage(Account account, PageRequest pageRequest) {
        return DataResult.successByDatas(this.accountService.queryByPage(account, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public DataResult<JSONObject> queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.accountService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult<JSONObject> add(Account account) {
        return DataResult.successByData(this.accountService.insert(account));
    }

    /**
     * 编辑数据
     *
     * @param account 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult<JSONObject> edit(Account account) {
        return DataResult.successByData(this.accountService.update(account));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult<JSONObject> deleteById(Integer id) {
        return DataResult.successByData(this.accountService.deleteById(id));
    }

    /**
     * 根据实体类查询
     * @param account
     * @return
     */
    @PostMapping("queryByAccount")
    public DataResult<List<Account>> queryByAccount(Account account){
        return DataResult.successByDatas(this.accountService.queryByAccount(account));
    }

}

