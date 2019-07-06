package org.stream.answerduel.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.stream.answerduel.config.FastJsonEnumSerializer;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/19 09:49
 */
@ApiModel("统一返回对象")
@Slf4j
@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    @JsonSerialize(using = FastJsonEnumSerializer.class)
    @ApiModelProperty("响应码")
    private HttpStatus code;

    @ApiModelProperty("描述")
    private String message;

    @ApiModelProperty("数据")
    private T data;

    public Result() {
    }

    public Result(HttpStatus code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result result(HttpStatus code, String message, T data) {
        return new Result(code, message, data);
    }

    public Result ok() {
        return new Result(HttpStatus.OK, "操作成功", null);
    }

    public Result ok(String message) {
        return new Result(HttpStatus.OK, message, null);
    }

    public Result ok(T data) {
        return new Result(HttpStatus.OK, "", data);
    }

    public Result ok(String message, T data) {
        return new Result(HttpStatus.OK, message, data);
    }

    public Result serverError() {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR, "服务器异常", null);
    }

    public Result serverError(String message) {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR, message, null);
    }

    public Result serverError(T data) {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR, "", data);
    }

    public Result serverError(String message, T data) {
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR, message, data);
    }

}
