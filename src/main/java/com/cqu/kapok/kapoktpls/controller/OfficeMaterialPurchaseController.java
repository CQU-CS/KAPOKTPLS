package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.OfficeMaterialPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.MaterialSale;
import com.cqu.kapok.kapoktpls.entity.Notice;
import com.cqu.kapok.kapoktpls.entity.OfficeMaterialPurchase;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.OfficeMaterialPurchaseService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.vo.NoticeVo;
import com.cqu.kapok.kapoktpls.vo.OfficeMaterialPurchaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private CompanyService companyService;

    /**
     * 分页查询
     * @param officeMaterialPurchaseDTO
     * @return
     */
    @PostMapping("queryByPage")
    public DataResult queryByPage(@RequestBody OfficeMaterialPurchaseDTO officeMaterialPurchaseDTO) {
        PageRequest pageRequest = PageRequest.of(officeMaterialPurchaseDTO.getPage()-1, officeMaterialPurchaseDTO.getSize());
        OfficeMaterialPurchase officeMaterialPurchase = new OfficeMaterialPurchase();
        BeanUtils.copyProperties(officeMaterialPurchaseDTO,officeMaterialPurchase);
        List<OfficeMaterialPurchase> officeMaterialPurchases = this.officeMaterialPurchaseService.queryByPage(officeMaterialPurchase, pageRequest).getContent();
        List<OfficeMaterialPurchaseVo> officeMaterialPurchaseVos = new ArrayList<>();
        for(OfficeMaterialPurchase officeMaterialPurchase1:officeMaterialPurchases) {
            OfficeMaterialPurchaseVo officeMaterialPurchaseVo = new OfficeMaterialPurchaseVo();
            BeanUtils.copyProperties(officeMaterialPurchase1,officeMaterialPurchaseVo);
            officeMaterialPurchaseVo.setCompanyName(this.companyService.queryById(officeMaterialPurchaseVo.getCompanyId()).getCompanyName());
            officeMaterialPurchaseVos.add(officeMaterialPurchaseVo);
        }
        Long total = this.officeMaterialPurchaseService.count(officeMaterialPurchase);
        return DataResult.successByTotalData(officeMaterialPurchaseVos,total);
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
    @PostMapping("add")
    public DataResult add(@RequestBody OfficeMaterialPurchase officeMaterialPurchase) {
        return DataResult.successByData(this.officeMaterialPurchaseService.insert(officeMaterialPurchase));
    }

    /**
     * 编辑数据
     *
     * @param officeMaterialPurchase 实体
     * @return 编辑结果
     */
    @PostMapping("edit")
    public DataResult edit(@RequestBody OfficeMaterialPurchase officeMaterialPurchase) {
        return DataResult.successByData(this.officeMaterialPurchaseService.update(officeMaterialPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteById")
    public DataResult deleteById(@RequestParam Integer id) {
        return this.officeMaterialPurchaseService.deleteById(id)?DataResult.succ():DataResult.err();
    }

    /**
     * 条件查询
     * @param officeMaterialPurchase
     * @return
     */
    @PostMapping("getByCondition")
    public DataResult getByCondition(@RequestBody  OfficeMaterialPurchase officeMaterialPurchase) {
        return DataResult.successByDatas(this.officeMaterialPurchaseService.getByCondition(officeMaterialPurchase));
    }

}

