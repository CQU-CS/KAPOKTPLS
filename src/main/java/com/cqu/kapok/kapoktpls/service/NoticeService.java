package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 09:43:52
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param noticeId 主键
     * @return 实例对象
     */
    Notice queryById(Integer noticeId);

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Notice> queryByPage(Notice notice, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);

    /**
     * 通过主键删除数据
     *
     * @param noticeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer noticeId);

    /**
     * 条件查询
     * @param notice
     * @return
     */
    List<Notice> getByCondition(Notice notice);

    /**
     * 计数
     * @param notice
     * @return
     */
    Long count(Notice notice);

}
