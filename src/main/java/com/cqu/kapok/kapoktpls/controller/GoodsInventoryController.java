package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.GoodsInventory;
import com.cqu.kapok.kapoktpls.service.GoodsInventoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (GoodsInventory)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:36:56
 */
@RestController
@RequestMapping("goodsInventory")
public class GoodsInventoryController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsInventoryService goodsInventoryService;

    /**
     * 分页查询
     *
     * @param goodsInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsInventory>> queryByPage(GoodsInventory goodsInventory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsInventoryService.queryByPage(goodsInventory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsInventory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsInventoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsInventory 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<GoodsInventory> add(GoodsInventory goodsInventory) {
        return ResponseEntity.ok(this.goodsInventoryService.insert(goodsInventory));
    }

    /**
     * 编辑数据
     *
     * @param goodsInventory 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<GoodsInventory> edit(GoodsInventory goodsInventory) {
        return ResponseEntity.ok(this.goodsInventoryService.update(goodsInventory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.goodsInventoryService.deleteById(id));
    }

}

