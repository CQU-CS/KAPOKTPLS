package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.service.RepairRecordService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RepairRecord)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
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
     * @param page
     * @param size
     * @return
     */
    @GetMapping("queryByPage")
    public DataResult queryByPage(@RequestParam Integer page,@RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page-1,size);
        RepairRecord repairRecord = new RepairRecord();
        return DataResult.successByData(this.repairRecordService.queryByPage(repairRecord, pageRequest));
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
     *
     * @param repairRecord
     * @return
     */
    @PostMapping("queryByRepairRecord")
    public DataResult<List<RepairRecord>> queryByRepairRecord(RepairRecord repairRecord){
        return this.repairRecordService.queryByRepairRecord(repairRecord);
    }
    /**
     * 新增数据
     *
     * @param repairRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RepairRecord> add(RepairRecord repairRecord) {
        return ResponseEntity.ok(this.repairRecordService.insert(repairRecord));
    }

    /**
     * 编辑数据
     *
     * @param repairRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RepairRecord> edit(RepairRecord repairRecord) {
        return ResponseEntity.ok(this.repairRecordService.update(repairRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.repairRecordService.deleteById(id));
    }


}

