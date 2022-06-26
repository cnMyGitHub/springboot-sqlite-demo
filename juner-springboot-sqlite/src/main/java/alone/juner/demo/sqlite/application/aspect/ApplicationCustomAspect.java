package alone.juner.demo.sqlite.application.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * <h3>AOP 切面</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 22:41 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
@Aspect
@Component
public class ApplicationCustomAspect {

    private final static String TIP = "切面运行顺序记录";

    private Integer count;

    @Pointcut("execution(* *.ApplicationCustomSmartLifecycle.start(..))")
    public void startup(){}

    @Before("startup()")
    public void before() {
        count = 0;
        calc();
        log.debug("{}: {} before", TIP, count);
    }

    @Around("startup()")
    public Object around(ProceedingJoinPoint pjp) {
        calc();
        log.debug("{}: {} around", TIP, count);
        return pjp;
    }

    @AfterReturning("startup()")
    public void afterReturning() {
        calc();
        log.debug("{}: {} afterReturning", TIP, count);
    }

    @AfterThrowing("startup()")
    public void afterThrowing() {
        calc();
        log.debug("{}: {} afterThrowing", TIP, count);
    }

    @After("startup()")
    public void after() {
        calc();
        log.debug("{}: {} after", TIP, count);
    }

    private void calc() {
        count++;
    }
}
