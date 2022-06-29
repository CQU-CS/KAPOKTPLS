package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.TruckPurchaseDTO;
import com.cqu.kapok.kapoktpls.dto.TruckRepairRecordDTO;
import com.cqu.kapok.kapoktpls.entity.TruckPurchase;
import com.cqu.kapok.kapoktpls.entity.TruckRepairRecord;
import com.cqu.kapok.kapoktpls.service.TruckRepairRecordService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TruckRepairRecord)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:13:08
 */
@RestController
@RequestMapping("truckRepairRecord")
public class TruckRepairRecordController {
    /**
     * 服务对象
     */
    @Resource
    private TruckRepairRecordService truckRepairRecordService;

    /**
     * 分页查询
     *
     * @param truckRepairRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TruckRepairRecord>> queryByPage(TruckRepairRecord truckRepairRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.truckRepairRecordService.queryByPage(truckRepairRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TruckRepairRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.truckRepairRecordService.queryById(id));
    }

    /**
     * 通过实体类查询
     *
     * @param truckRepairRecord
     * @return
     */
    @PostMapping("queryByTruckRepairRecord")
    public DataResult<List<TruckRepairRecord>> queryByTruckRepairRecord(TruckRepairRecord truckRepairRecord){
        return DataResult.successByDatas(this.truckRepairRecordService.queryByTruckRepairRecord(truckRepairRecord));
    }

    /**
     * 新增数据
     *
     * @param truckRepairRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TruckRepairRecord> add(TruckRepairRecord truckRepairRecord) {
        return ResponseEntity.ok(this.truckRepairRecordService.insert(truckRepairRecord));
    }

    /**
     * 编辑数据
     *
     * @param truckRepairRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TruckRepairRecord> edit(TruckRepairRecord truckRepairRecord) {
        return ResponseEntity.ok(this.truckRepairRecordService.update(truckRepairRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.truckRepairRecordService.deleteById(id));
    }

    /**
     * 通过queryByTruckRepairRecordDTO分页查询
     *
     * @param truckRepairRecordDTO
     * @return
     */
    @PostMapping("queryByTruckRepairRecordDTO")
    DataResult queryByTruckRepairRecordDTO(@RequestBody TruckRepairRecordDTO truckRepairRecordDTO){
        truckRepairRecordDTO.setPage((truckRepairRecordDTO.getPage() - 1) * truckRepairRecordDTO.getLimit());
        List<TruckRepairRecord> truckRepairRecords =this.truckRepairRecordService.queryByTruckRepairRecordDTO(truckRepairRecordDTO);
        TruckRepairRecord truckRepairRecord = new TruckRepairRecord();
        BeanUtils.copyProperties(truckRepairRecordDTO,truckRepairRecord);
        Long total = this.truckRepairRecordService.getTruckRepairRecordByConditionCount(truckRepairRecord);
        return DataResult.successByTotalData(truckRepairRecords, total);
    }
}

