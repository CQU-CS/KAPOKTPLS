package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dao.NoticeDao;
import com.cqu.kapok.kapoktpls.dto.NoticeDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.Notice;
import com.cqu.kapok.kapoktpls.service.NoticeService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.NoticeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private PersonService personService;

    /**
     * 分页查询
     * @param noticeDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody NoticeDTO noticeDTO) {
        PageRequest pageRequest = PageRequest.of(noticeDTO.getPage()-1, noticeDTO.getSize());
        Notice notice = new Notice();
        BeanUtils.copyProperties(noticeDTO,notice);
        List<Notice> notices = this.noticeService.queryByPage(notice, pageRequest).getContent();
        List<NoticeVo> noticeVos = new ArrayList<>();
        for(Notice notice1:notices) {
            NoticeVo noticeVo = new NoticeVo();
            BeanUtils.copyProperties(notice1,noticeVo);
            noticeVo.setPersonName(this.personService.queryById(noticeVo.getPersonId()).getPersonName());
            noticeVos.add(noticeVo);
        }
        Long total = this.noticeService.count(notice);
        return DataResult.successByTotalData(noticeVos,total);
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
    @PostMapping("add")
    public DataResult add(@RequestBody Notice notice) {
        return DataResult.successByData(this.noticeService.insert(notice));
    }

    /**
     * 编辑数据
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody Notice notice) {
        return DataResult.successByData(this.noticeService.update(notice));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestParam Integer id) {
        return this.noticeService.deleteById(id)?DataResult.succ():DataResult.err();
    }

    /**
     * 条件查询
     * @param notice
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody Notice notice) {
        return DataResult.successByDatas(this.noticeService.getByCondition(notice));
    }

}

