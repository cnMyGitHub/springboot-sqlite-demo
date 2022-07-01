package alone.juner.demo.sqlite.application.impl;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

/**
 * <h3>启动信息服务</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description 服务启动后输出的基本信息
 * @date 2022年06月30日 18:24 星期四
 * @since JDK_1.8.0.271
 */
public interface StartInfoServer {

    @SneakyThrows
    static void message(String[] args, Environment env, Logger logger) {
        String info = "\n\t----------------------------------------------------------\n\t";
        if(args.length > 2) {
            logger.info(info +" {}" + info + args);
        }

        logger.warn(info +
                    " Application '{}' is running! Access URLs:\n\t" +
                    " Local: \t\thttp://localhost:{}\n\t" +
                    " External: \thttp://{}:{}\n\t" +
                    " Doc: \thttp://{}:{}/doc.html\n\t" +
                    " \t\t天地不仁，以万物为刍狗 " +
                    info,

                // Application
                env.getProperty("spring.application.name") == null ? "data-server" : env.getProperty("spring.application.name"),

                // Local Port
                env.getProperty("server.port"),

                // External
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),

                // API Doc
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")
        );
    }
}
