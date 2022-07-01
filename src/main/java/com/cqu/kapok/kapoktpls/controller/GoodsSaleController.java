package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.GoodsSaleDTO;
import com.cqu.kapok.kapoktpls.dto.ProfitDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.entity.GoodsSale;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.GoodsSaleService;
import com.cqu.kapok.kapoktpls.service.GoodsService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.GoodsSaleVo;
import com.cqu.kapok.kapoktpls.vo.GoodsSaleVo;
import com.cqu.kapok.kapoktpls.vo.GoodsSaleVo;
import com.cqu.kapok.kapoktpls.vo.ProfitVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * (GoodsSale)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:18:44
 */
@RestController
@RequestMapping("goodsSale")
public class GoodsSaleController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsSaleService goodsSaleService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private CompanyService companyService;
    /**
     * 分页查询
     *
     * @param goodsSale 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsSale>> queryByPage(GoodsSale goodsSale, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsSaleService.queryByPage(goodsSale, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsSale> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsSaleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsSaleVo 实体
     * @return 新增结果
     */
    @PostMapping("addGoodsSale")
    public DataResult add(@RequestBody GoodsSaleVo goodsSaleVo) {
        GoodsSale goodsSale = new GoodsSale();
        BeanUtils.copyProperties(goodsSaleVo,goodsSale);

        Goods goods = new Goods();
        Company company = new Company();

        goods.setGoodsName(goodsSaleVo.getGoodsName());
        System.out.println(goodsSaleVo.getGoodsName());
        company.setCompanyName(goodsSaleVo.getCompanyName());
        System.out.println(goodsSaleVo.getCompanyName());

        List<Goods> goodss = this.goodsService.queryByGoods(goods);
        List<Company> companys = this.companyService.queryCompany(company);
        System.out.println("11111111111111111");
        if(goodss.size() != 0){
            System.out.println("获取good");
            goodsSale.setGoodsId(goodss.get(0).getGoodsId());
        }else{
            //插入操作
            System.out.println("插入good");
            goods.setGoodsId(6666);
            Goods goods1 = this.goodsService.insert(goods);
            goodsSale.setGoodsId(goods1.getGoodsId());
        }

        if(companys.size() != 0){
            System.out.println("获取com");
            goodsSale.setCompanyId(companys.get(0).getCompanyId());
        }else{
            //插入操作
            System.out.println("插入com");
            company.setCompanyId(6666);
            company.setAddressId(666);
            Company company1 = this.companyService.insert(company);
            goodsSale.setCompanyId(company1.getCompanyId());
        }

        return DataResult.successByData(this.goodsSaleService.insert(goodsSale));
    }


    /**
     * 编辑数据
     *
     * @param goodsSaleVo 实体
     * @return 编辑结果
     */
    @PostMapping("editGoodsSale")
    public DataResult edit(@RequestBody GoodsSaleVo goodsSaleVo) {
        GoodsSale goodsSale = new GoodsSale();
        BeanUtils.copyProperties(goodsSaleVo,goodsSale);

        Goods goods = new Goods();
        Company company = new Company();

        goods.setGoodsName(goodsSaleVo.getGoodsName());
        System.out.println(goodsSaleVo.getGoodsName());
        company.setCompanyName(goodsSaleVo.getCompanyName());
        System.out.println(goodsSaleVo.getCompanyName());

        List<Goods> goodss = this.goodsService.queryByGoods(goods);
        List<Company> companys = this.companyService.queryCompany(company);
        System.out.println("11111111111111111");
        if(goodss.size() != 0){
            System.out.println("获取good");
            goodsSale.setGoodsId(goodss.get(0).getGoodsId());
        }else{
            //插入操作
            System.out.println("插入good");
            goods.setGoodsId(6666);
            Goods goods1 = this.goodsService.insert(goods);
            goodsSale.setGoodsId(goods1.getGoodsId());
        }

        if(companys.size() != 0){
            System.out.println("获取com");
            goodsSale.setCompanyId(companys.get(0).getCompanyId());
        }else{
            //插入操作
            System.out.println("插入com");
            company.setCompanyId(6666);
            company.setAddressId(666);
            Company company1 = this.companyService.insert(company);
            goodsSale.setCompanyId(company1.getCompanyId());
        }

        return DataResult.successByData(this.goodsSaleService.update(goodsSale));
    }


    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteGoodsSale")
    public DataResult deleteById(Integer id) {
        boolean b = this.goodsSaleService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }

    @PostMapping("queryByGoodsSale")
    DataResult queryByGoods(@RequestBody GoodsSaleDTO goodsSaleDTO){
        goodsSaleDTO.setPage((goodsSaleDTO.getPage() - 1) * goodsSaleDTO.getLimit());
        List<GoodsSale> goodsSales =this.goodsSaleService.queryAll(goodsSaleDTO);
        GoodsSale goodsSale = new GoodsSale();
        BeanUtils.copyProperties(goodsSaleDTO,goodsSale);
        Long total = this.goodsSaleService.getGoodsSaleByConditionCount(goodsSale);

        Goods goods = new Goods();
        ArrayList<GoodsSaleVo> goodsSaleVos = new ArrayList<>();
        for(GoodsSale goodsSale1: goodsSales){
            goods.setGoodsId(goodsSale1.getGoodsId());
            List<Goods> goodss = this.goodsService.queryByGoods(goods);
            //货物名称
            String goodsName = goodss.get(0).getGoodsName();
            GoodsSaleVo goodsSaleVo = new GoodsSaleVo();
            BeanUtils.copyProperties(goodsSale1,goodsSaleVo);
            goodsSaleVo.setGoodsName(goodsName);


            //公司名称
            Company company = this.companyService.queryById(goodsSale1.getCompanyId());
            String companyName = company.getCompanyName();
            goodsSaleVo.setCompanyName(companyName);
            goodsSaleVos.add(goodsSaleVo);
        }
        return DataResult.successByTotalData(goodsSaleVos, total);
    }
    /**
     * 通过ProfitDTO查询利润
     *
     * @param profitDTO
     * @return
     */
    @PostMapping("getGoodsSaleProfit")
    DataResult getGoodsSaleProfit(ProfitDTO profitDTO){
        ProfitVo profitVo = new ProfitVo();
        Long goodsSaleProfit = this.goodsSaleService.getGoodsSaleProfit(profitDTO);
        profitVo.setProfit(goodsSaleProfit);
        return DataResult.successByData(profitVo);

    }
}

