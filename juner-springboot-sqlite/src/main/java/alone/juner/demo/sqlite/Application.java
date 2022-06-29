package alone.juner.demo.sqlite;

import alone.juner.demo.sqlite.application.listener.ApplicationCustomListener;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.InetAddress;

/**
 * <h3>主应用程序</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:18 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
@EnableWebMvc
@EnableAspectJAutoProxy
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class Application {

    @SneakyThrows
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(Application.class);

        application.addListeners(new ApplicationCustomListener());

        application.run(args);

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        Environment env = context.getEnvironment();

        log.info("\n\t----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "----------------------------------------------------------",

                // Application
                env.getProperty("spring.application.name"),

                // Local Port
                env.getProperty("server.port"),

                // External
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")
        );
    }

}
