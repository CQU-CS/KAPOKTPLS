package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.Token;
import com.cqu.kapok.kapoktpls.dao.TokenDao;
import com.cqu.kapok.kapoktpls.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Token)表服务实现类
 *
 * @author makejava
 * @since 2022-06-27 16:30:59
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    @Resource
    private TokenDao tokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tokenValue 主键
     * @return 实例对象
     */
    @Override
    public Token queryById(String tokenValue) {
        return this.tokenDao.queryById(tokenValue);
    }

    /**
     * 分页查询
     *
     * @param token 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Token> queryByPage(Token token, PageRequest pageRequest) {
        long total = this.tokenDao.count(token);
        return new PageImpl<>(this.tokenDao.queryAllByLimit(token, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token insert(Token token) {
        this.tokenDao.insert(token);
        return token;
    }

    /**
     * 修改数据
     *
     * @param token 实例对象
     * @return 实例对象
     */
    @Override
    public Token update(Token token) {
        this.tokenDao.update(token);
        return this.queryById(token.getTokenValue());
    }

    /**
     * 通过主键删除数据
     *
     * @param tokenValue 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String tokenValue) {
        return this.tokenDao.deleteById(tokenValue) > 0;
    }
}
