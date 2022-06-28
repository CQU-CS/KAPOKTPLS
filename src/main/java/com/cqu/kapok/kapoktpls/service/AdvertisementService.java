package com.cqu.kapok.kapoktpls.service;

import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Advertisement)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 08:56:08
 */
public interface AdvertisementService {

    /**
     * 通过ID查询单条数据
     *
     * @param advertisementId 主键
     * @return 实例对象
     */
    Advertisement queryById(Integer advertisementId);

    /**
     * 分页查询
     *
     * @param advertisement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Advertisement> queryByPage(Advertisement advertisement, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    Advertisement insert(Advertisement advertisement);

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    Advertisement update(Advertisement advertisement);

    /**
     * 通过主键删除数据
     *
     * @param advertisementId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer advertisementId);

    /**
     * 根据实体类查询
     * @param advertisement
     * @return
     */
    DataResult<List<Advertisement>> queryByAdvertisement(Advertisement advertisement);
}
