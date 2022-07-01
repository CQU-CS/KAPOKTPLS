package com.cqu.kapok.kapoktpls.controller;

import com.cqu.kapok.kapoktpls.dto.GoodsPurchaseDTO;
import com.cqu.kapok.kapoktpls.entity.*;
import com.cqu.kapok.kapoktpls.entity.GoodsPurchase;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.CompanyService;
import com.cqu.kapok.kapoktpls.service.GoodsPurchaseService;
import com.cqu.kapok.kapoktpls.service.GoodsService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import com.cqu.kapok.kapoktpls.vo.GoodsPurchaseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (GoodsPurchase)表控制层
 *
 * @author makejava
 * @since 2022-06-28 21:11:50
 */
@RestController
@RequestMapping("goodsPurchase")
public class GoodsPurchaseController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsPurchaseService goodsPurchaseService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private CompanyService companyService;
    /**
     * 分页查询
     *
     * @param goodsPurchase 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<GoodsPurchase>> queryByPage(GoodsPurchase goodsPurchase, PageRequest pageRequest) {
        return ResponseEntity.ok(this.goodsPurchaseService.queryByPage(goodsPurchase, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<GoodsPurchase> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.goodsPurchaseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param goodsPurchaseVo 实体
     * @return 新增结果
     */
    @PostMapping("addGoodsPurchase")
    public DataResult add(@RequestBody GoodsPurchaseVo goodsPurchaseVo) {
        GoodsPurchase goodsPurchase = new GoodsPurchase();
        BeanUtils.copyProperties(goodsPurchaseVo,goodsPurchase);

        Goods goods = new Goods();
        Company company = new Company();

        goods.setGoodsName(goodsPurchaseVo.getGoodsName());
        System.out.println(goodsPurchaseVo.getGoodsName());
        company.setCompanyName(goodsPurchaseVo.getCompanyName());
        System.out.println(goodsPurchaseVo.getCompanyName());

        List<Goods> goodss = this.goodsService.queryByGoods(goods);
        List<Company> companys = this.companyService.queryCompany(company);
        System.out.println("11111111111111111");
        if(goodss.size() != 0){
            System.out.println("获取good");
            goodsPurchase.setGoodsId(goodss.get(0).getGoodsId());
        }else{
            //插入操作
            System.out.println("插入good");
            goods.setGoodsId(6666);
            Goods goods1 = this.goodsService.insert(goods);
            goodsPurchase.setGoodsId(goods1.getGoodsId());
        }

        if(companys.size() != 0){
            System.out.println("获取com");
            goodsPurchase.setCompanyId(companys.get(0).getCompanyId());
        }else{
            //插入操作
            System.out.println("插入com");
            company.setCompanyId(6666);
            Company company1 = this.companyService.insert(company);
            goodsPurchase.setCompanyId(company1.getCompanyId());
        }

        return DataResult.successByData(this.goodsPurchaseService.insert(goodsPurchase));
    }

    /**
     * 编辑数据
     *
     * @param goodsPurchaseVo 实体
     * @return 编辑结果
     */
    @PostMapping("editGoodsPurchase")
    public DataResult edit(@RequestBody GoodsPurchaseVo goodsPurchaseVo) {
        GoodsPurchase goodsPurchase = new GoodsPurchase();
        BeanUtils.copyProperties(goodsPurchaseVo,goodsPurchase);

        Goods goods = new Goods();
        Company company = new Company();

        goods.setGoodsName(goodsPurchaseVo.getGoodsName());
        System.out.println(goodsPurchaseVo.getGoodsName());
        company.setCompanyName(goodsPurchaseVo.getCompanyName());
        System.out.println(goodsPurchaseVo.getCompanyName());

        List<Goods> goodss = this.goodsService.queryByGoods(goods);
        List<Company> companys = this.companyService.queryCompany(company);
        System.out.println("11111111111111111");
        if(goodss.size() != 0){
            System.out.println("获取good");
            goodsPurchase.setGoodsId(goodss.get(0).getGoodsId());
        }else{
            //插入操作
            System.out.println("插入good");
            goods.setGoodsId(6666);
            Goods goods1 = this.goodsService.insert(goods);
            goodsPurchase.setGoodsId(goods1.getGoodsId());
        }

        if(companys.size() != 0){
            System.out.println("获取com");
            goodsPurchase.setCompanyId(companys.get(0).getCompanyId());
        }else{
            //插入操作
            System.out.println("插入com");
            company.setCompanyId(6666);
            Company company1 = this.companyService.insert(company);
            goodsPurchase.setCompanyId(company1.getCompanyId());
        }

        return DataResult.successByData(this.goodsPurchaseService.update(goodsPurchase));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteGoodsPurchase")
    public DataResult deleteById(Integer id) {
        boolean b = this.goodsPurchaseService.deleteById(id);
        return DataResult.errByErrCode(Code.SUCCESS);
    }


    @PostMapping("queryByGoodsPurchase")
    DataResult queryByGoods(@RequestBody GoodsPurchaseDTO goodsPurchaseDTO){
        goodsPurchaseDTO.setPage((goodsPurchaseDTO.getPage() - 1) * goodsPurchaseDTO.getLimit());
        List<GoodsPurchase> goodsPurchases =this.goodsPurchaseService.queryAll(goodsPurchaseDTO);
        GoodsPurchase goodsPurchase = new GoodsPurchase();
        BeanUtils.copyProperties(goodsPurchaseDTO,goodsPurchase);
        Long total = this.goodsPurchaseService.getGoodsPurchaseByConditionCount(goodsPurchase);

        Goods goods = new Goods();
        ArrayList<GoodsPurchaseVo> goodsPurchaseVos = new ArrayList<>();
        for(GoodsPurchase goodsPurchase1: goodsPurchases){
            goods.setGoodsId(goodsPurchase1.getGoodsId());
            List<Goods> goodss = this.goodsService.queryByGoods(goods);
            //货物名称
            String goodsName = goodss.get(0).getGoodsName();
            GoodsPurchaseVo goodsPurchaseVo = new GoodsPurchaseVo();
            BeanUtils.copyProperties(goodsPurchase1,goodsPurchaseVo);
            goodsPurchaseVo.setGoodsName(goodsName);


            //公司名称
            Company company = this.companyService.queryById(goodsPurchase1.getCompanyId());
            String companyName = company.getCompanyName();
            goodsPurchaseVo.setCompanyName(companyName);
            goodsPurchaseVos.add(goodsPurchaseVo);
        }
        return DataResult.successByTotalData(goodsPurchaseVos, total);
    }
}

