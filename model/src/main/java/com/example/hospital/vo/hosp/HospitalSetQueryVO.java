package com.example.hospital.vo.hosp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class HospitalSetQueryVO {

    @ApiModelProperty("医院名称")
    private String hospName;

    @ApiModelProperty("医院编号")
    private String hospCode;
}
