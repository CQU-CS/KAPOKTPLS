package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.entity.RepairRecord;
import com.cqu.kapok.kapoktpls.entity.TransportationTask;
import com.cqu.kapok.kapoktpls.service.TransportationTaskService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TransportationTask)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:12:34
 */
@RestController
@RequestMapping("transportationTask")
public class TransportationTaskController {
    /**
     * 服务对象
     */
    @Resource
    private TransportationTaskService transportationTaskService;

    /**
     * 分页查询
     *
     * @param transportationTask 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TransportationTask>> queryByPage(TransportationTask transportationTask, PageRequest pageRequest) {
        return ResponseEntity.ok(this.transportationTaskService.queryByPage(transportationTask, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TransportationTask> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.transportationTaskService.queryById(id));
    }

    /**
     *
     * @param transportationTask
     * @return
     */
    @PostMapping("queryByTransportationTask")
    public DataResult<List<TransportationTask>> queryByTransportationTask(TransportationTask transportationTask){
        return this.transportationTaskService.queryByTransportationTask(transportationTask);
    }

    /**
     * 新增数据
     *
     * @param transportationTask 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TransportationTask> add(TransportationTask transportationTask) {
        return ResponseEntity.ok(this.transportationTaskService.insert(transportationTask));
    }

    /**
     * 编辑数据
     *
     * @param transportationTask 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TransportationTask> edit(TransportationTask transportationTask) {
        return ResponseEntity.ok(this.transportationTaskService.update(transportationTask));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.transportationTaskService.deleteById(id));
    }

}

