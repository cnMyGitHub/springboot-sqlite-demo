package alone.juner.demo.sqlite.application.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <h3>命令行运行器</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 22:55 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
@Order(1)
@Component
public class CustomCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.debug("命令行运行器");
    }
}
