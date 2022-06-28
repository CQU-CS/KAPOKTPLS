package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.service.RepairRecordService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

/**
 * (RepairRecord)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:44:59
 */
@RestController
@RequestMapping("repairRecord")
public class RepairRecordController {
    /**
     * 服务对象
     */
    @Resource
    private RepairRecordService repairRecordService;

    /**
     * 分页查询
     *
     * @param repairRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RepairRecord>> queryByPage(RepairRecord repairRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.repairRecordService.queryByPage(repairRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RepairRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repairRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param repairRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(@RequestBody RepairRecord repairRecord) {
        return DataResult.successByData(this.repairRecordService.insert(repairRecord));
    }

    /**
     * 编辑数据
     *
     * @param repairRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(@RequestBody RepairRecord repairRecord) {
        return DataResult.successByData(this.repairRecordService.update(repairRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.repairRecordService.deleteById(id));
    }

    /**
     * 条件查询
     * @param repairRecord
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody RepairRecord repairRecord) {
        return DataResult.successByData(this.repairRecordService.getByCondition(repairRecord));
    }

}

