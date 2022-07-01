package com.cqu.kapok.kapoktpls.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.cqu.kapok.kapoktpls.dto.GoodsDTO;
import com.cqu.kapok.kapoktpls.dto.MaterialDTO;
import com.cqu.kapok.kapoktpls.entity.Goods;
import com.cqu.kapok.kapoktpls.entity.Material;
import com.cqu.kapok.kapoktpls.service.MaterialService;
import com.cqu.kapok.kapoktpls.utils.result.DataResult;
import com.cqu.kapok.kapoktpls.utils.result.code.Code;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * (Material)表控制层
 *
 * @author makejava
 * @since 2022-06-28 10:09:56
 */
@RestController
@RequestMapping("material")
public class MaterialController {
    /**
     * 服务对象
     */
    @Resource
    private MaterialService materialService;

    /**
     * 分页查询
     *
     * @param material 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Material>> queryByPage(Material material, PageRequest pageRequest) {
        return ResponseEntity.ok(this.materialService.queryByPage(material, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Material> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.materialService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param material 实体
     * @return 新增结果
     */
    @PostMapping("addMaterial")
    public DataResult add(@RequestBody Material material) {
        return DataResult.successByData(this.materialService.insert(material));
    }

    /**
     * 编辑数据
     *
     * @param material 实体
     * @return 编辑结果
     */
    @PostMapping("editMaterial")
    public DataResult edit(@RequestBody Material material) {
        return DataResult.successByData(this.materialService.update(material));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("deleteMaterial")
    public DataResult deleteById(Integer id) {
        System.out.println("获取数据"+id);
        boolean b = this.materialService.deleteById(id);

        return DataResult.errByErrCode(Code.SUCCESS);
    }


    @PostMapping("queryByMaterial")
    DataResult queryByGoods(@RequestBody MaterialDTO materialDTO){
        materialDTO.setPage((materialDTO.getPage() - 1) * materialDTO.getLimit());
        List<Material> materials = this.materialService.queryAllByCondition(materialDTO);
        Material material = new Material();
        BeanUtils.copyProperties(materialDTO,materials);
        Long total = this.materialService.getMaterialByConditionCount(material);
        return DataResult.successByTotalData(materials, total);
    }

    @GetMapping("exportMaterial")
    public void export(HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = CollUtil.newArrayList();

        Material material = new Material();
        List<Material> all = this.materialService.queryByMaterial(material);
        for (Material material1 : all) {
            Map<String, Object> row1 = new LinkedHashMap<>();
            row1.put("物资编号", material1.getMaterialId());
            row1.put("物资名称", material1.getMaterialName());
            row1.put("物资类型", material1.getMaterialType());
            row1.put("物资价格", material1.getMaterialPrice());
            row1.put("物资尺寸", material1.getMaterialSize());
            list.add(row1);
        }

        // 2. 写excel
        ExcelWriter writer = ExcelUtil.getWriter(true);
        writer.write(list, true);

        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("物资信息", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        writer.close();
        IoUtil.close(System.out);
    }

}

