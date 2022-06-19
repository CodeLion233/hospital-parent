package com.example.hospital.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.common.exception.HospitalException;
import com.example.hospital.common.result.Result;
import com.example.hospital.common.result.ResultCodeEnum;
import com.example.hospital.entity.hosp.HospitalSet;
import com.example.hospital.service.HospitalSetService;
import com.example.hospital.vo.hosp.HospitalSetQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 医院设置表 前端控制器
 * </p>
 *
 * @author huangjiahao
 * @since 2022-06-12
 */
@RestController
@Api(tags = "医院设置管理")
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {

    @Autowired
    private HospitalSetService hospitalSetService;

    @ApiOperation("获取所有医院设置")
    @GetMapping("findAll")
    public Result findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.success(list);
    }

    @ApiOperation("逻辑删除医院设置")
    @DeleteMapping("{id}")
    public Result removeHospSet(@PathVariable long id) {
        boolean flag = hospitalSetService.removeById(id);
        if (flag) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    @ApiOperation("分页查询")
    @PostMapping("findPageHospSet/{current}/{limit}")
    public Result findPageHospSet(@PathVariable long current,
                                  @PathVariable long limit,
                                  @RequestBody HospitalSetQueryVO hospitalSetQueryVO) {
        Page<HospitalSet> page = new Page<>(current, limit);
        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();
        String hospName = hospitalSetQueryVO.getHospName();
        String hospCode = hospitalSetQueryVO.getHospCode();
        if (!StringUtils.isEmpty(hospCode)) {
            queryWrapper.eq("hosp_code", hospCode);
        }
        if (!StringUtils.isEmpty(hospName)) {
            queryWrapper.like("hosp_name", hospName);
        }
        Page<HospitalSet> result = hospitalSetService.page(page, queryWrapper);
        return Result.success(result);
    }

}
