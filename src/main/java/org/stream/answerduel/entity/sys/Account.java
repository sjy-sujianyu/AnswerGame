package org.stream.answerduel.entity.sys;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.stream.answerduel.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 功能描述：系统用户实体
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/17 14:03
 */
@Slf4j
@Data
@Accessors(chain = true)
@Entity
@Table(name = "sys_account")
public class Account extends BaseEntity {

    /**
     * 账号
     */
    @Column(name = "username", unique = true)
    private String username;

    /**
     * 邮箱
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 加密密码的盐
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 昵称
     */
    @Column(name = "nickname")
    private String nickname;

    /**
     * 真实姓名
     */
    @Column(name = "realname")
    private String realname;

    /**
     * 用户头像图片的base64码保存
     */
    @Column(name = "avatar_base64")
    private String avatarBase64;

    /**
     * 用户级别类型：
     */
    @Column(name = "level_type")
    private Integer levelType;

    /**
     * 生日
     */
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 用户性别
     * 0	未知
     * 1	男性
     * 2	女性
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 账号状态：
     */
    @Column(name = "state")
    private Integer state;

}
