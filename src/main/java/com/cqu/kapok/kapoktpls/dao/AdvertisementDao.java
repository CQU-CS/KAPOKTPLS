package com.cqu.kapok.kapoktpls.dao;

import com.cqu.kapok.kapoktpls.dto.AdvertisementDTO;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Advertisement)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-28 08:56:08
 */
public interface AdvertisementDao {

    /**
     * 通过ID查询单条数据
     *
     * @param advertisementId 主键
     * @return 实例对象
     */
    Advertisement queryById(Integer advertisementId);

    /**
     * 查询指定行数据
     *
     * @param advertisement 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Advertisement> queryAllByLimit(Advertisement advertisement, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param advertisement 查询条件
     * @return 总行数
     */
    long count(Advertisement advertisement);

    /**
     * 新增数据
     *
     * @param advertisement 实例对象
     * @return 影响行数
     */
    int insert(Advertisement advertisement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Advertisement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Advertisement> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Advertisement> entities);

    /**
     * 修改数据
     *
     * @param advertisement 实例对象
     * @return 影响行数
     */
    int update(Advertisement advertisement);

    /**
     * 通过主键删除数据
     *
     * @param advertisementId 主键
     * @return 影响行数
     */
    int deleteById(Integer advertisementId);

    /**
     * 根据实体类查询
     * @param advertisement
     * @return
     */
    List<Advertisement> queryByAdvertisement(Advertisement advertisement);

    /**
     * 分页查询
     * @param advertisementDTO
     * @return
     */
    List<Advertisement> queryByAdvertisementDTO(AdvertisementDTO advertisementDTO);

    /**
     * 分页数量
     * @param advertisement
     * @return
     */
    Long getAdvertisementByConditionCount(Advertisement advertisement);
}

