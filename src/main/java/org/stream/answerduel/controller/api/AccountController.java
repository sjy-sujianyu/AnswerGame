package org.stream.answerduel.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stream.answerduel.controller.BaseController;
import org.stream.answerduel.dto.PageResult;
import org.stream.answerduel.dto.Result;
import org.stream.answerduel.service.AccountService;
import org.stream.answerduel.vo.sys.AccountVo;

/**
 * 功能描述：
 * https://www.jianshu.com/p/cf9ad8c3621d
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/24 11:38
 */
@Api("我是接口")
@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    /**
     * 功能描述：
     *
     * @param accountVo
     * @return
     */
    @ApiOperation(value = "新增", notes = "新增数据")
    @ApiImplicitParams({
    })
    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody AccountVo accountVo) {
        accountService.add(accountVo);
        return new ResponseEntity(new Result().ok("add success"), HttpStatus.OK);
    }

    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除", notes = "删除数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户标识", required = true, dataType = "Long", example = "xxx"),
    })
    @DeleteMapping("/del")
    public ResponseEntity<Result> del(Long id) {
        accountService.del(id);
        return new ResponseEntity(new Result().ok("del success"), HttpStatus.OK);
    }

    /**
     * 功能描述：
     *
     * @return
     */
    @ApiOperation(value = "查询", notes = "查询数据")
    @ApiImplicitParams({
    })
    @PostMapping("/select")
    public ResponseEntity<PageResult<AccountVo>> select(Integer pageSize, Integer pageNumber) {
        return new ResponseEntity(new Result().ok("register success", accountService.select(pageSize, pageNumber)), HttpStatus.OK);
    }

    /**
     * 功能描述：
     *
     * @param accountVo
     * @return
     */
    @ApiOperation(value = "修改", notes = "修改数据")
    @ApiImplicitParams({
    })
    @PutMapping("/update")
    public ResponseEntity<Result> update(@RequestBody AccountVo accountVo) {
        accountService.update(accountVo);
        return new ResponseEntity(new Result().ok("register success"), HttpStatus.OK);
    }

}
