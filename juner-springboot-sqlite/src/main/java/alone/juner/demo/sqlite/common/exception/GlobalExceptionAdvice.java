package alone.juner.demo.sqlite.common.exception;

import alone.juner.demo.sqlite.common.exception.custom.BusinessesException;
import alone.juner.demo.sqlite.common.request.GlobalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <h3>全局异常处理机制</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月30日 13:03 星期四
 * @since JDK_1.8.0.271
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 处理其他异常
     *
     * @param e 异常
     * @return 系统内部错误
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    public GlobalResponse globalHandler(Exception e) {
        log.error("Exception, exception:{}", e.getMessage(), e);
        return GlobalResponse.error();
    }

    /**
     * <strong>捕获运行异常</strong>
     *
     * @description 使用统一返回样式返回
     * @param e 运行时异常
     * @return ResponseEntity
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(RuntimeException.class)
    public GlobalResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("RuntimeException, exception:{}", e.getMessage(), e);
        return GlobalResponse.error();
    }

    /**
     * 操作异常
     *
     * @param e 校验异常
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(BusinessesException.class)
    public GlobalResponse operationException(BusinessesException e) {
        log.error("BusinessesException, cdoe:{}， exception:{}", e.getCode(), e.getMessage());
        return GlobalResponse.error(e.getMessage());
    }

}
