package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Material;
import com.cqu.kapok.kapoktpls.service.MaterialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Material)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:09:56
 */
@RestController
@RequestMapping("material")
public class MaterialController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialService materialService;

    /**
     * 分页查询
     *
     * @param material 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Material>> queryByPage(Material material, PageRequest pageRequest) {
        return ResponseEntity.ok(this.materialService.queryByPage(material, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Material> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param material 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Material> add(Material material) {
        return ResponseEntity.ok(this.materialService.insert(material));
    }

    /**
     * 编辑数据
     *
     * @param material 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Material> edit(Material material) {
        return ResponseEntity.ok(this.materialService.update(material));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.materialService.deleteById(id));
    }

}

