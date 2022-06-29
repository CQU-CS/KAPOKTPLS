package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import com.cqu.kapok.kapoktpls.service.OfficeMaterialPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (OfficeMaterialPurchase)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:44:07
 */
@RestController
@RequestMapping("officeMaterialPurchase")
public class OfficeMaterialPurchaseController {
    /**
     * 服务对象
     */
    @Resource
    private OfficeMaterialPurchaseService officeMaterialPurchaseService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("queryByPage")
    public DataResult queryByPage(@RequestParam Integer page,@RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        OfficeMaterialPurchase officeMaterialPurchase = new OfficeMaterialPurchase();
        return DataResult.successByData(this.officeMaterialPurchaseService.queryByPage(officeMaterialPurchase, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<OfficeMaterialPurchase> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.officeMaterialPurchaseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param officeMaterialPurchase 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(@RequestBody OfficeMaterialPurchase officeMaterialPurchase) {
        return DataResult.successByData(this.officeMaterialPurchaseService.insert(officeMaterialPurchase));
    }

    /**
     * 编辑数据
     *
     * @param officeMaterialPurchase 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(@RequestBody OfficeMaterialPurchase officeMaterialPurchase) {
        return DataResult.successByData(this.officeMaterialPurchaseService.update(officeMaterialPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.officeMaterialPurchaseService.deleteById(id));
    }

    /**
     * 条件查询
     * @param officeMaterialPurchase
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody  OfficeMaterialPurchase officeMaterialPurchase) {
        return DataResult.successByData(this.officeMaterialPurchaseService.getByCondition(officeMaterialPurchase));
    }

}

