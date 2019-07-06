package org.stream.answerduel.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Slf4j
@Order(-5)
@Aspect
@Component
public class AppLogAspect {

    /* 保证每个线程都有一个单独的实例 */
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 功能描述：切面 controller 对所有的方法起作用
     */
//    @Pointcut("execution(* com.tocean.demo.controller.*(..))")
    public void pointcut() {
    }

    /**
     * 功能描述：
     *
     * @param joinPoint
     */
//    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        /* 设置当前的时间 */
        threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        /* 记录请求的内容 */
        log.info("Request URL: {}", request.getRequestURL().toString());
        log.info("Request Method: {}", request.getMethod());
        log.info("IP: {}", request.getRemoteAddr());
        log.info("User-Agent:{}", request.getHeader("User-Agent"));
        log.info("Class Method:{}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("Cookies:{}", request.getCookies());
        log.info("Params:{}", Arrays.toString(joinPoint.getArgs()));

        /* 所有的请求的入参 */
        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            log.info("{}:{}", paraName, request.getParameter(paraName));
        }
    }

    /**
     * 功能描述：
     *
     * @param joinPoint
     */
//    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("doAfter():{}", joinPoint.toString());
    }

    /**
     * 功能描述：
     *
     * @param joinPoint
     */
//    @AfterReturning("pointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        log.info("耗时:{} ms", ((System.currentTimeMillis() - threadLocal.get())));
    }

}
