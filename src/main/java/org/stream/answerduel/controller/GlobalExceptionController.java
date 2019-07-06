package org.stream.answerduel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.stream.answerduel.dto.Result;

import javax.servlet.http.HttpServletRequest;

/**
 * 功能描述：
 *
 * @Auther: 梁展鹏
 * @Date: 2018/7/24 11:38
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    /**
     * 功能描述：抛出错误前，打印错误日志
     *
     * @param httpServletRequest
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Result> handleException(HttpServletRequest httpServletRequest, Exception exception) {
        log.error(exception.getMessage(), exception);

        if (exception instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            return new ResponseEntity<>(new Result().serverError(exception.getMessage()), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new Result().serverError(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 功能描述：捕捉控制器里面自己抛出的所有异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Result> globalException(HttpServletRequest request, Throwable ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new Result().serverError(ex.getMessage(), null), getStatus(request));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
