package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.service.BuildingRentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BuildingRent)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:57:04
 */
@RestController
@RequestMapping("buildingRent")
public class BuildingRentController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingRentService buildingRentService;

    /**
     * 分页查询
     *
     * @param buildingRent 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BuildingRent>> queryByPage(BuildingRent buildingRent, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingRentService.queryByPage(buildingRent, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BuildingRent> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildingRentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildingRent 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BuildingRent> add(BuildingRent buildingRent) {
        return ResponseEntity.ok(this.buildingRentService.insert(buildingRent));
    }

    /**
     * 编辑数据
     *
     * @param buildingRent 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BuildingRent> edit(BuildingRent buildingRent) {
        return ResponseEntity.ok(this.buildingRentService.update(buildingRent));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildingRentService.deleteById(id));
    }

}
