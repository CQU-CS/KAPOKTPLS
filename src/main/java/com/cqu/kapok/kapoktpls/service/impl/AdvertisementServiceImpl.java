package com.cqu.kapok.kapoktpls.service.impl;

import com.cqu.kapok.kapoktpls.dto.AdvertisementDTO;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.dao.AdvertisementDao;
import com.cqu.kapok.kapoktpls.service.AdvertisementService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Advertisement)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 08:56:08
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
    @Resource
    private AdvertisementDao advertisementDao;

    /**
     * 通过ID查询单条数据
     *
     * @param advertisementId 主键
     * @return 实例对象
     */
    @Override
    public Advertisement queryById(Integer advertisementId) {
        return this.advertisementDao.queryById(advertisementId);
    }

    /**
     * 分页查询
     *
     * @param advertisement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Advertisement> queryByPage(Advertisement advertisement, PageRequest pageRequest) {
        long total = this.advertisementDao.count(advertisement);
        return new PageImpl<>(this.advertisementDao.queryAllByLimit(advertisement, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisement insert(Advertisement advertisement) {
        this.advertisementDao.insert(advertisement);
        return advertisement;
    }

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 实例对象
     */
    @Override
    public Advertisement update(Advertisement advertisement) {
        this.advertisementDao.update(advertisement);
        return this.queryById(advertisement.getAdvertisementId());
    }

    /**
     * 通过主键删除数据
     *
     * @param advertisementId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer advertisementId) {
        return this.advertisementDao.deleteById(advertisementId) > 0;
    }


    /**
     * 根据实体类查询
     * @param advertisement
     * @return
     */
    @Override
    public List<Advertisement> queryByAdvertisement(Advertisement advertisement) {
        return this.advertisementDao.queryByAdvertisement(advertisement);
    }

    /**
     * 分页查询
     * @param advertisementDTO
     * @return
     */
    @Override
    public List<Advertisement> queryByAdvertisementDTO(AdvertisementDTO advertisementDTO) {
        return this.advertisementDao.queryByAdvertisementDTO(advertisementDTO);
    }

    /**
     * 分页查询数量
     * @param advertisement
     * @return
     */
    @Override
    public Long getAdvertisementByConditionCount(Advertisement advertisement) {
        return this.advertisementDao.getAdvertisementByConditionCount(advertisement);
    }
}
