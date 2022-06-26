package alone.juner.demo.sqlite;

import alone.juner.demo.sqlite.application.listener.ApplicationCustomListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <h3>主应用程序</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:18 星期日
 * @since JDK_1.8.0.271
 */
@EnableAspectJAutoProxy
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationCustomListener());
        application.run(args);
        SpringApplication.run(Application.class, args);
    }
}
