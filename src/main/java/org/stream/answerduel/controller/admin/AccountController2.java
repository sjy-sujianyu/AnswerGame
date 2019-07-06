package org.stream.answerduel.controller.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stream.answerduel.controller.BaseController;
import org.stream.answerduel.dto.Result;

/**
 * 功能描述：
 * https://www.jianshu.com/p/cf9ad8c3621d
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/24 11:38
 */
@Api("我是管理后台")
@Slf4j
@RestController
@RequestMapping("/admin/account2")
public class AccountController2 extends BaseController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @ApiOperation(value = "发送消息", notes = "系统全局异常、error日志、编程式通知等场景")
    @PostMapping("/login")
    public ResponseEntity<Result> login() {
        return new ResponseEntity(new Result().ok("login success", ""), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Result> signup() {
        return new ResponseEntity(new Result().ok("register success"), HttpStatus.OK);
    }

}
