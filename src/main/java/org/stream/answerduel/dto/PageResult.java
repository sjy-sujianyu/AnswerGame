package org.stream.answerduel.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * 功能描述：
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/19 09:49
 */
@ApiModel("统一返回分页对象")
@Slf4j
@Data
@Accessors(chain = true)
public class PageResult<T> implements Serializable {

    @ApiModelProperty("当前页码")
    private Integer pageNumber;

    @ApiModelProperty("分页大小")
    private Integer pageSize;

    @ApiModelProperty("总数")
    private Integer total;

    @ApiModelProperty("数据")
    private List<T> data;

    public PageResult() {
    }

    public PageResult(Integer pageNumber, Integer pageSize, Integer total, List<T> data) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }

}
