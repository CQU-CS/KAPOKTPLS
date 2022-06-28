package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Address;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.service.AdvertisementService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Advertisement)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:56:08
 */
@RestController
@RequestMapping("advertisement")
public class AdvertisementController {
    /**
     * 服务对象
     */
    @Resource
    private AdvertisementService advertisementService;

    /**
     * 分页查询
     *
     * @param advertisement 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Advertisement>> queryByPage(Advertisement advertisement, PageRequest pageRequest) {
        return ResponseEntity.ok(this.advertisementService.queryByPage(advertisement, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Advertisement> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.advertisementService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param advertisement 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Advertisement> add(Advertisement advertisement) {
        return ResponseEntity.ok(this.advertisementService.insert(advertisement));
    }

    /**
     * 编辑数据
     *
     * @param advertisement 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Advertisement> edit(Advertisement advertisement) {
        return ResponseEntity.ok(this.advertisementService.update(advertisement));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.advertisementService.deleteById(id));
    }


    /**
     * 根据实体类查询
     * @param advertisement
     * @return
     */
    @PostMapping("queryByAdvertisement")
    public DataResult<List<Advertisement>> queryByAdvertisement(Advertisement advertisement){
        return this.advertisementService.queryByAdvertisement(advertisement);
    }

}

