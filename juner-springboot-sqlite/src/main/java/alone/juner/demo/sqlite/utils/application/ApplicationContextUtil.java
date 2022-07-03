package alone.juner.demo.sqlite.utils.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <h3>Spring上下文工具</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年07月01日 15:30 星期五
 * @since JDK_1.8.0.271
 */
public class ApplicationContextUtil implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

}

