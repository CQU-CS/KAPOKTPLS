package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.entity.Notice;
import com.cqu.kapok.kapoktpls.dao.NoticeDao;
import com.cqu.kapok.kapoktpls.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 09:43:52
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer noticeId) {
        return this.noticeDao.queryById(noticeId);
    }

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Notice> queryByPage(Notice notice, PageRequest pageRequest) {
        long total = this.noticeDao.count(notice);
        return new PageImpl<>(this.noticeDao.queryAllByLimit(notice, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getNoticeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer noticeId) {
        return this.noticeDao.deleteById(noticeId) > 0;
    }

    /**
     * 条件查询
     * @param notice
     * @return
     */
    @Override
    public List<Notice> getByCondition(Notice notice) {
        return this.noticeDao.getByCondition(notice);
    }
}
