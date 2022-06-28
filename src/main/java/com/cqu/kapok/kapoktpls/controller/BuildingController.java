package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Building;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Building)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:56:47
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingService buildingService;

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Building>> queryByPage(Building building, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingService.queryByPage(building, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Building> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param building 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Building> add(Building building) {
        return ResponseEntity.ok(this.buildingService.insert(building));
    }

    /**
     * 编辑数据
     *
     * @param building 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Building> edit(Building building) {
        return ResponseEntity.ok(this.buildingService.update(building));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildingService.deleteById(id));
    }

}

