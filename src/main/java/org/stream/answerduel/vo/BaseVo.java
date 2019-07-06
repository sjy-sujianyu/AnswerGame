package org.stream.answerduel.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Slf4j
@Data
@Accessors(chain = true)
public class BaseVo implements Serializable {

    private Long id;

    private Long createBy;

    private Long updateBy;

    private Date createAt;

    private Date updateAt;

    private Boolean isDel = Boolean.FALSE;

}
