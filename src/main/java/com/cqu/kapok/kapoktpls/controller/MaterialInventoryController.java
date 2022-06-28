package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.MaterialInventoryDTO;
import com.cqu.kapok.kapoktpls.entity.Material;
import com.cqu.kapok.kapoktpls.entity.MaterialInventory;
import com.cqu.kapok.kapoktpls.service.MaterialInventoryService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (MaterialInventory)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:19:34
 */
@RestController
@RequestMapping("materialInventory")
public class MaterialInventoryController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialInventoryService materialInventoryService;

    /**
     * 分页查询
     *
     * @param materialInventory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<MaterialInventory>> queryByPage(MaterialInventory materialInventory, PageRequest pageRequest) {
        return ResponseEntity.ok(this.materialInventoryService.queryByPage(materialInventory, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MaterialInventory> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialInventoryService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param materialInventory 实体
     * @return 新增结果
     */
    @PostMapping("addMaterialInventory")
    public ResponseEntity<MaterialInventory> add(MaterialInventory materialInventory) {
        return ResponseEntity.ok(this.materialInventoryService.insert(materialInventory));
    }

    /**
     * 编辑数据
     *
     * @param materialInventory 实体
     * @return 编辑结果
     */
    @PutMapping("editMaterialInventory")
    public ResponseEntity<MaterialInventory> edit(MaterialInventory materialInventory) {
        return ResponseEntity.ok(this.materialInventoryService.update(materialInventory));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("deleteMaterialInventory")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.materialInventoryService.deleteById(id));
    }

    @PostMapping("queryByMaterialInventory")
    DataResult queryByGoods(@RequestBody MaterialInventoryDTO materialInventoryDTO){
        materialInventoryDTO.setPage((materialInventoryDTO.getPage() - 1) * materialInventoryDTO.getLimit());
        List<MaterialInventory> materialInventorys = this.materialInventoryService.queryAll(materialInventoryDTO);
        MaterialInventory materialInventory = new MaterialInventory();
        BeanUtils.copyProperties(materialInventoryDTO,materialInventory);
        Long total = this.materialInventoryService.getMaterialInventoryByConditionCount(materialInventory);
        return DataResult.successByTotalData(materialInventorys, total);
    }
}

