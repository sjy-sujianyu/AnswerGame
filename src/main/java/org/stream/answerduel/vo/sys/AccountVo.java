package org.stream.answerduel.vo.sys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.stream.answerduel.vo.BaseVo;

import java.util.Date;

/**
 * 功能描述：系统用户实体
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/17 14:03
 */
@ApiModel("系统用户实体")
@Slf4j
@Data
@Accessors(chain = true)
public class AccountVo extends BaseVo {

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String username;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String phoneNumber;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realname;

    /**
     * 用户头像图片的base64码保存
     */
    @ApiModelProperty("用户头像图片的base64码保存")
    private String avatarBase64;

    /**
     * 用户级别类型：
     */
    @ApiModelProperty("用户级别类型")
    private Integer levelType;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 用户性别
     * 0	未知
     * 1	男性
     * 2	女性
     */
    @ApiModelProperty("用户性别")
    private Integer gender;

}
