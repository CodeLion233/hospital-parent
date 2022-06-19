package com.example.hospital.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.hosp.HospitalSet;
import com.example.hospital.mapper.HospitalSetMapper;
import com.example.hospital.service.HospitalSetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hospital.vo.hosp.HospitalSetQueryVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 医院设置表 服务实现类
 * </p>
 *
 * @author huangjiahao
 * @since 2022-06-12
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    private HospitalSetMapper hospitalSetMapper;

    @Override
    public Page<HospitalSet> findPageHospSet(long current, long limit, HospitalSetQueryVO hospitalSetQueryVO) {
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
        return hospitalSetMapper.selectPage(page, queryWrapper);
    }
}
