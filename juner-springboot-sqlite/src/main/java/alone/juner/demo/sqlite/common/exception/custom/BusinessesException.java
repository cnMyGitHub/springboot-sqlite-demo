package alone.juner.demo.sqlite.common.exception.custom;

/**
 * <h3>业务异常</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月30日 13:03 星期四
 * @since JDK_1.8.0.271
 */
public class BusinessesException extends RuntimeException {

    private final int code;

    private final String message;

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BusinessesException(String message) {
        super();
        this.code = 500;
        this.message = message;
    }

    public BusinessesException(String message, int code) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessesException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BusinessesException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BusinessesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.message = message;
    }

}

