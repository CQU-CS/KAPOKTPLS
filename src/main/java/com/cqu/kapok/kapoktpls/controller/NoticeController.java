package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dao.NoticeDao;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.Notice;
import com.cqu.kapok.kapoktpls.service.NoticeService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Notice)表控制层
 *
 * @author makejava
 * @since 2022-06-28 09:43:52
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @GetMapping("queryByPage")
    public DataResult queryByPage(@RequestParam Integer page,@RequestParam Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Notice notice = new Notice();
        return DataResult.successByData(this.noticeService.queryByPage(notice, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Notice> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.noticeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param notice 实体
     * @return 新增结果
     */
    @PostMapping
    public DataResult add(@RequestBody Notice notice) {
        return DataResult.successByData(this.noticeService.insert(notice));
    }

    /**
     * 编辑数据
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PutMapping
    public DataResult edit(@RequestBody Notice notice) {
        return DataResult.successByData(this.noticeService.update(notice));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public DataResult deleteById(Integer id) {
        return DataResult.successByData(this.noticeService.deleteById(id));
    }

    /**
     * 条件查询
     * @param notice
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody Notice notice) {
        return DataResult.successByData(this.noticeService.getByCondition(notice));
    }

}

