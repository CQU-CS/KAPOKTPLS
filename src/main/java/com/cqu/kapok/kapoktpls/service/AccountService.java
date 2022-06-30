package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.dto.AccountDTO;
import com.cqu.kapok.kapoktpls.entity.Account;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Account)表服务接口
 *
 * @author makejava
 * @since 2022-06-27 22:23:22
 */
public interface AccountService {

    /**
     * 通过ID查询单条数据
     *
     * @param accountId 主键
     * @return 实例对象
     */
    Account queryById(Integer accountId);

    /**
     * 分页查询
     *
     * @param account 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Account> queryByPage(Account account, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account insert(Account account);

    /**
     * 修改数据
     *
     * @param account 实例对象
     * @return 实例对象
     */
    Account update(Account account);

    /**
     * 通过主键删除数据
     *
     * @param accountId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer accountId);

    /**
     * 验证账号是否存在
     * @param account
     * @return
     */
    Account queryLogin(Account account);

    /**
     * 根据实体类查询
     * @param account
     * @return
     */
    List<Account> queryByAccount(Account account);

    /**
     * 根据token查询account
     * @param token
     * @return
     */
    Account queryByToken(String token);

    /**
     * 分页查询
     * @param accountDTO
     * @return
     */
    List<Account> queryByAccountDTO(AccountDTO accountDTO);

    /**
     * 分页查询数量
     * @param account1
     * @return
     */
    Long getAccountByConditionCount(Account account1);

    List<Account> getPictureByNickname(Account account);
}
