package com.cqu.kapok.kapoktpls.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.kapok.kapoktpls.dto.AccountDTO;
import com.cqu.kapok.kapoktpls.dto.AddressDTO;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.service.AccountService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public DataResult queryById(@PathVariable("id") Integer id) {
        return DataResult.successByData(this.accountService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param account 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(Account account) {
        return DataResult.successByData(this.accountService.insert(account));
    }

    /**
     * 编辑数据
     *
     * @param account 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(Account account) {
        return DataResult.successByData(this.accountService.update(account));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.accountService.deleteById(id));
    }

    /**
     * 根据实体类查询
     * @param account
     * @return
     */
    @PostMapping("queryByAccount")
    public DataResult queryByAccount(Account account){
        return DataResult.successByData(this.accountService.queryByAccount(account));
    }


    /**
     * 通过AccountDTO分页查询
     * @param accountDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByAccountDTO")
    DataResult queryByAccountDTO(@RequestBody AccountDTO accountDTO){
        accountDTO.setPage((accountDTO.getPage() - 1) * accountDTO.getLimit());
        List<Account> accounts =this.accountService.queryByAccountDTO(accountDTO);
        Account account1 = new Account();
        BeanUtils.copyProperties(accountDTO,account1);
        Long total = this.accountService.getAccountByConditionCount(account1);
        return DataResult.successByTotalData(accounts, total);
    }

    /**
     * 通过nickname获取头像
     */

    @PostMapping("getPictureByNickname")
    public DataResult getPictureByNickname(@RequestBody Account account){
//        ArrayList<Account> arrayList = new ArrayList<>();
        List<Account> accounts = this.accountService.getPictureByNickname(account);
//        for(Account a: accounts){
//            arrayList.add(a);
//        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("infor",accounts);
        return DataResult.successByData(jsonObject);
    }


}

