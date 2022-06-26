package alone.juner.demo.sqlite.common.validator.custom;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h3>校验接口</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 22:58 星期日
 * @since JDK_1.8.0.271
 */
@Target({ ElementType.FIELD }) // 校验作用name域 字段、枚举 上
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckServer.class) // 校验的逻辑处理类
public @interface Check {
    String regex(); // 正则表达式校验
    String field(); // 字段名称
    String message() default "自校验失败！请检查。"; // 校验失败的提示信息
    Class<?>[] groups() default { } ; // 分组校验，例如只在新增时进行校验等
}
