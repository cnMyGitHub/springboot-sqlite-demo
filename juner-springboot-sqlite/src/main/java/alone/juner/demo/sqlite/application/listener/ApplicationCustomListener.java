package alone.juner.demo.sqlite.application.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <h3>事件监听器</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 22:36 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
@Component
public class ApplicationCustomListener
        implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.debug("容器初始化完毕 -> {}", event.toString());
    }
}
