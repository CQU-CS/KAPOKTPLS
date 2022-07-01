package com.cqu.kapok.kapoktpls.controller;

import com.alibaba.fastjson.JSONObject;
import com.cqu.kapok.kapoktpls.dto.AccountDTO;
import com.cqu.kapok.kapoktpls.dto.AddressDTO;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.service.AccountService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.AccountVo;
import com.cqu.kapok.kapoktpls.vo.BuildingVo;
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

    @Resource
    private PersonService personService;
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
    @PostMapping("addByAccount")
    public DataResult add(@RequestBody Account account) {
        if(account!=null){
            return DataResult.successByData(this.accountService.insert(account));
        }else{
            account.setAccountPicture("https://s1.ax1x.com/2022/06/29/jm03Qg.png");
            return DataResult.errByErrCode(Code.ACCOUNTROOT_DELETE_ERROR);
        }

    }

    /**
     * 编辑数据
     *
     * @param account 实体
     * @return 编辑结果
     */
    @PostMapping("editByAccount")
    public DataResult edit(@RequestBody Account account) {
        Account account1 = this.accountService.queryById(account.getAccountId());
        if(!account1.getAccountType().equals("root")){
            return DataResult.successByData(this.accountService.update(account));
        }else{
            return DataResult.errByErrCode(Code.ACCOUNTROOT_DELETE_ERROR);
        }

    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(Integer id) {
        try {
            Account account1 = this.accountService.queryById(id);
            if(!account1.getAccountType().equals("root")){
                boolean b = this.accountService.deleteById(id);
            }else{
                return DataResult.errByErrCode(Code.ACCOUNTROOT_DELETE_ERROR);
            }
        } catch (Exception e) {
            System.out.println("异常");
            return DataResult.errByErrCode(Code.ACCOUNTROOT_DELETE_ERROR);
        }
        System.out.println("正常");
        return DataResult.errByErrCode(Code.SUCCESS);
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

        List<AccountVo> accountVos = new ArrayList<>();
        //1.获取主要数据
        accountDTO.setPage((accountDTO.getPage() - 1) * accountDTO.getLimit());
        List<Account> accounts =this.accountService.queryByAccountDTO(accountDTO);
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO,account);
        Long total = this.accountService.getAccountByConditionCount(account);
        //添加次要数据
        for(Account account1:accounts){
            String personName = this.personService.queryById(account1.getPersonId()).getPersonName();
            AccountVo accountVo = new AccountVo();
            BeanUtils.copyProperties(account1,accountVo);
            accountVo.setPersonName(personName);
            accountVos.add(accountVo);
        }
        return DataResult.successByTotalData(accountVos, total);
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

