package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.CompanyDTO;
import com.cqu.kapok.kapoktpls.dto.EcdDTO;
import com.cqu.kapok.kapoktpls.entity.Company;
import com.cqu.kapok.kapoktpls.entity.Ecd;
import com.cqu.kapok.kapoktpls.service.BuildingService;
import com.cqu.kapok.kapoktpls.service.EcdService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.CompanyVo;
import com.cqu.kapok.kapoktpls.vo.EcdVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Ecd)表控制层
 *
 * @author makejava
 * @since 2022-06-28 14:49:09
 */
@RestController
@RequestMapping("ecd")
public class EcdController {
    /**
     * 服务对象
     */
    @Resource
    private EcdService ecdService;
    @Resource
    private BuildingService buildingService;


    /**
     * 分页查询
     *
     * @param ecd 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Ecd>> queryByPage(Ecd ecd, PageRequest pageRequest) {
        return ResponseEntity.ok(this.ecdService.queryByPage(ecd, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Ecd> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ecdService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param ecd 实体
     * @return 新增结果
     */
    @PostMapping("addByEcd")
    public ResponseEntity<Ecd> add(Ecd ecd) {
        return ResponseEntity.ok(this.ecdService.insert(ecd));
    }

    /**
     * 编辑数据
     *
     * @param ecd 实体
     * @return 编辑结果
     */
    @PostMapping("editByEcd")
    public ResponseEntity<Ecd> edit(Ecd ecd) {
        return ResponseEntity.ok(this.ecdService.update(ecd));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteByEcdId")
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.ecdService.deleteById(id));
    }
    /**
     * 通过EcdDTO分页查询
     * @param ecdDTO
     * @return 查询结果列表和查询总数
     */
    @PostMapping("queryByEcd")
    DataResult queryByEcd(@RequestBody EcdDTO ecdDTO){
        ArrayList<EcdVo> ecdVos = new ArrayList<>();
        ecdDTO.setPage((ecdDTO.getPage() - 1) * ecdDTO.getLimit());
        List<Ecd> ecds =this.ecdService.queryAll(ecdDTO);
        Ecd ecd = new Ecd();
        BeanUtils.copyProperties(ecdDTO,ecd);
        Long total = this.ecdService.getEcdByConditionCount(ecd);
        for(Ecd ecd1:ecds){
            String buildingName = this.buildingService.queryById(ecd1.getBuildingId()).getBuildingName();
            EcdVo ecdVo = new EcdVo();
            BeanUtils.copyProperties(ecd1,ecdVo);
            ecdVo.setBuildingName(buildingName);
            ecdVos.add(ecdVo);
        }
        return DataResult.successByTotalData(ecdVos, total);
    }
}

