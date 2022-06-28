package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.dao.AccountDao;
import com.cqu.kapok.kapoktpls.service.AccountService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Account)表服务实现类
 *
 * @author makejava
 * @since 2022-06-27 22:23:22
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    @Override
    public Account queryById(Integer accountId) {
        return this.accountDao.queryById(accountId);
    }

    /**
     * 分页查询
     *
     * @param account 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Account> queryByPage(Account account, PageRequest pageRequest) {
        long total = this.accountDao.count(account);
        return new PageImpl<>(this.accountDao.queryAllByLimit(account, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account insert(Account account) {
        this.accountDao.insert(account);
        return account;
    }

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    @Override
    public Account update(Account account) {
        System.out.println("正确的:"+account.toString());
        this.accountDao.update(account);
        return this.queryById(account.getAccountId());
    }

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer accountId) {
        return this.accountDao.deleteById(accountId) > 0;
    }


    /**
     * 验证账号是否存在
     * @param account
     * @return
     */
    @Override
    public Account queryLogin(Account account) {
        return this.accountDao.queryLogin(account);
    }

    /**
     * 根据实体类查询
     * @param account
     * @return
     */
    @Override
    public List<Account> queryByAccount(Account account) {
        return this.accountDao.queryByAccount(account);
    }

    /**
     * 根据token查询account
     * @param token
     * @return
     */
    @Override
    public Account queryByToken(String token) {
        return this.accountDao.queryByToken(token);
    }
}
