package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import com.cqu.kapok.kapoktpls.service.MaterialUseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (MaterialUse)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:43:26
 */
@RestController
@RequestMapping("materialUse")
public class MaterialUseController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialUseService materialUseService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("queryByPage")
    public DataResult queryByPage(@RequestParam Integer page,@RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        MaterialUse materialUse = new MaterialUse();
        return DataResult.successByData(this.materialUseService.queryByPage(materialUse, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<MaterialUse> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialUseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param materialUse 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(@RequestBody MaterialUse materialUse) {
        return DataResult.successByData(this.materialUseService.insert(materialUse));
    }

    /**
     * 编辑数据
     *
     * @param materialUse 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(@RequestBody MaterialUse materialUse) {
        return DataResult.successByData(this.materialUseService.update(materialUse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.materialUseService.deleteById(id));
    }

    /**
     * 条件查询
     * @param materialUse
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody MaterialUse materialUse) {
        return DataResult.successByData(this.materialUseService.getByCondition(materialUse));
    }

}

