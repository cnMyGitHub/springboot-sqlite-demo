package alone.juner.demo.sqlite.application.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * <h3>智能生命周期</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 22:37 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
@Component
public class ApplicationCustomSmartLifecycle
        implements SmartLifecycle {

    /**
     * 存储作为信号标识
     */
    private boolean isRunning;

    @Override
    public void start() {
        log.debug(" <Smart> 通知： 启动 <Smart> ");
        log.debug(" <Smart> 通知： 允许启动任务或其他异步服务");
        isRunning = true;
    }

    @Override
    public void stop() {
        log.debug(" <Smart> 通知： 程序即将停止靠岸 ... ");
        isRunning = false;
    }

    @Override
    public boolean isRunning() {
        log.debug(" <Smart> 通知： 检查是否正在运行");
        return isRunning;
    }
}
