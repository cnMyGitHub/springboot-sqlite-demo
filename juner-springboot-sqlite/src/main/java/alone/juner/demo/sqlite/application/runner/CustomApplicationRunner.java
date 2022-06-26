package alone.juner.demo.sqlite.application.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <h3>应用程序运行器</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 22:53 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
@Order(1)
@Component
public class CustomApplicationRunner
        implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("应用程序运行器");
    }
}
