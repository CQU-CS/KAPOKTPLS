package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.MaterialUseDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.MaterialUse;
import com.cqu.kapok.kapoktpls.entity.Notice;
import com.cqu.kapok.kapoktpls.entity.Person;
import com.cqu.kapok.kapoktpls.service.MaterialService;
import com.cqu.kapok.kapoktpls.service.MaterialUseService;
import com.cqu.kapok.kapoktpls.service.PersonService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.MaterialUseVo;
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

    @Resource
    private PersonService personService;

    @Resource
    private MaterialService materialService;

    /**
     * 分页查询
     * @param materialUseDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody MaterialUseDTO materialUseDTO) {
        PageRequest pageRequest = PageRequest.of(materialUseDTO.getPage()-1, materialUseDTO.getSize());
        MaterialUse materialUse = new MaterialUse();
        BeanUtils.copyProperties(materialUseDTO,materialUse);
        List<MaterialUse> materialUses = this.materialUseService.queryByPage(materialUse, pageRequest).getContent();
        List<MaterialUseVo> materialUseVos = new ArrayList<>();
        for(MaterialUse materialUse1:materialUses) {
            MaterialUseVo materialUseVo = new MaterialUseVo();
            BeanUtils.copyProperties(materialUse1,materialUseVo);
            materialUseVo.setPersonName(this.personService.queryById(materialUseVo.getPersonId()).getPersonName());
            materialUseVo.setMaterialName(this.materialService.queryById(materialUseVo.getMaterialId()).getMaterialName());
            materialUseVos.add(materialUseVo);
        }
        Long total = this.materialUseService.count(materialUse);
        return DataResult.successByTotalData(materialUseVos,total);
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
    @PostMapping("add")
    public DataResult add(@RequestBody MaterialUse materialUse) {
        return DataResult.successByData(this.materialUseService.insert(materialUse));
    }

    /**
     * 编辑数据
     *
     * @param materialUse 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody MaterialUse materialUse) {
        return DataResult.successByData(this.materialUseService.update(materialUse));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestParam Integer id) {
        return this.materialUseService.deleteById(id)?DataResult.succ():DataResult.err();
    }

    /**
     * 条件查询
     * @param materialUse
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody MaterialUse materialUse) {
        return DataResult.successByDatas(this.materialUseService.getByCondition(materialUse));
    }

}

