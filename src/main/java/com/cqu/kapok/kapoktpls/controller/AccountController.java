package com.cqu.kapok.kapoktpls.controller;

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
    public ResponseEntity<Page<Account>> queryByPage(Account account, PageRequest pageRequest) {
        return ResponseEntity.ok(this.accountService.queryByPage(account, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Account> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.accountService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Account> add(Account account) {
        return ResponseEntity.ok(this.accountService.insert(account));
    }

    /**
     * 编辑数据
     *
     * @param account 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Account> edit(Account account) {
        return ResponseEntity.ok(this.accountService.update(account));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.accountService.deleteById(id));
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

