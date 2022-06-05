package com.example.hospital.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 统一返回结果类
 */
@Data
@ApiModel("统一返回结果类")
public class Result<T> {

    @ApiModelProperty("返回码")
    private Integer code;

    @ApiModelProperty("返回信息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    public Result() {}

    protected static <T> Result<T> setResult(T data) {
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data);
        return result;
    }

    public static <T> Result<T> setResult(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = setResult(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    public static <T> Result<T> setResult(Integer code, String message) {
        Result<T> result = setResult(null);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> success(){
        return Result.success(null);
    }

    public static<T> Result<T> success(T data){
        Result<T> result = setResult(data);
        return setResult(data, ResultCodeEnum.SUCCESS);
    }

    public static<T> Result<T> error(){
        return Result.error(null);
    }

    public static<T> Result<T> error(T data){
        Result<T> result = setResult(data);
        return setResult(data, ResultCodeEnum.FAIL);
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }

    public boolean isSuccess() {
        return this.getCode().intValue() == ResultCodeEnum.SUCCESS.getCode().intValue();
    }
}
