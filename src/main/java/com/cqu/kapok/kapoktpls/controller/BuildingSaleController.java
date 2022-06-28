package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.BuildingRent;
import com.cqu.kapok.kapoktpls.entity.BuildingSale;
import com.cqu.kapok.kapoktpls.service.BuildingSaleService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BuildingSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 08:57:16
 */
@RestController
@RequestMapping("buildingSale")
public class BuildingSaleController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingSaleService buildingSaleService;

    /**
     * 分页查询
     *
     * @param buildingSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<BuildingSale>> queryByPage(BuildingSale buildingSale, PageRequest pageRequest) {
        return ResponseEntity.ok(this.buildingSaleService.queryByPage(buildingSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<BuildingSale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildingSaleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param buildingSale 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BuildingSale> add(BuildingSale buildingSale) {
        return ResponseEntity.ok(this.buildingSaleService.insert(buildingSale));
    }

    /**
     * 编辑数据
     *
     * @param buildingSale 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<BuildingSale> edit(BuildingSale buildingSale) {
        return ResponseEntity.ok(this.buildingSaleService.update(buildingSale));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildingSaleService.deleteById(id));
    }

    /**
     * 根据实体类查询
     * @param buildingSale
     * @return
     */
    @PostMapping("queryByBuildingSale")
    public DataResult<List<BuildingSale>> queryByBuildingSale(BuildingSale buildingSale){
        return DataResult.successByDatas(this.buildingSaleService.queryByBuildingSale(buildingSale));
    }

}

