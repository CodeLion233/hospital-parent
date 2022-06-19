package com.example.hospital.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hospital.entity.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hospital.vo.hosp.HospitalSetQueryVO;

/**
 * <p>
 * 医院设置表 服务类
 * </p>
 *
 * @author huangjiahao
 * @since 2022-06-12
 */
public interface HospitalSetService extends IService<HospitalSet> {

    Page<HospitalSet> findPageHospSet(long current, long limit, HospitalSetQueryVO hospitalSetQueryVO);

    boolean saveData(HospitalSet hospitalSet);
}
