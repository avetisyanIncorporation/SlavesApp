package my.app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Pargev 20.01.2023
 */
@Aspect
@Component
public class MyAspect {

    static {
        System.out.println("MyAspect initialization");
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(@Profiling *) && execution(public * *(..))")
    public void callAtProfilingPublic() { }

//    @Pointcut("execution(public * my.app.controller.SlaveController.*(..))")

    @Before("callAtProfilingPublic()")
    public void beforeCallAtMethods(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("before " + jp + ", args=[" + args + "]");
    }

    @After("callAtProfilingPublic()")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }
}
