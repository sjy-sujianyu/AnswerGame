package org.stream.answerduel.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stream.answerduel.dto.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class SystemErrorController extends AbstractErrorController {

    // 异常路径网址
    private final String PATH = "/error";

    public SystemErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping("/error")
    public ResponseEntity<Result> error(HttpServletRequest request) {
        /* 获取request中的异常信息，里面有好多，比如时间、路径啥的，大家可以自行遍历map查看 */
        Map<String, Object> attributes = getErrorAttributes(request, true);

        /* 这里只选择返回message字段 */
        return new ResponseEntity<>(new Result(getStatus(request), (String) attributes.get("message"), null), getStatus(request));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

}
