package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.RepairRecordDTO;
import com.cqu.kapok.kapoktpls.entity.Advertisement;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.service.RepairRecordService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.PersonVo;
import com.cqu.kapok.kapoktpls.vo.RepairRecordVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private PersonService personService;

    /**
     * 分页查询
     * @param repairRecordDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody RepairRecordDTO repairRecordDTO) {
        PageRequest pageRequest = PageRequest.of(repairRecordDTO.getPage()-1, repairRecordDTO.getSize());
        RepairRecord repairRecord = new RepairRecord();
        BeanUtils.copyProperties(repairRecordDTO,repairRecord);
        List<RepairRecord> repairRecords = this.repairRecordService.queryByPage(repairRecord, pageRequest).getContent();
        List<RepairRecordVo> repairRecordVos = new ArrayList<>();
        for(RepairRecord repairRecord1:repairRecords) {
            RepairRecordVo repairRecordVo = new RepairRecordVo();
            BeanUtils.copyProperties(repairRecord1,repairRecordVo);
            repairRecordVo.setPersonName(this.personService.queryById(repairRecordVo.getPersonId()).getPersonName());
            repairRecordVos.add(repairRecordVo);
        }
        Long total = this.repairRecordService.count(repairRecord);
        return DataResult.successByTotalData(repairRecordVos,total);
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
    @PostMapping("add")
    public DataResult add(@RequestBody RepairRecord repairRecord) {
        return DataResult.successByData(this.repairRecordService.insert(repairRecord));
    }

    /**
     * 编辑数据
     *
     * @param repairRecord 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody RepairRecord repairRecord) {
        return DataResult.successByData(this.repairRecordService.update(repairRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestParam Integer id) {
        return this.repairRecordService.deleteById(id)?DataResult.succ():DataResult.err();
    }

    /**
     * 条件查询
     * @param repairRecord
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody RepairRecord repairRecord) {
        return DataResult.successByDatas(this.repairRecordService.getByCondition(repairRecord));
    }
}

