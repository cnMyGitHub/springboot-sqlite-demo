package alone.juner.demo.sqlite.common.validator.basic;

import alone.juner.demo.sqlite.common.validator.custom.Check;

import javax.validation.ConstraintValidatorContext;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * <h3>默认检查接口</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 23:01 星期日
 * @since JDK_1.8.0.271
 */
public interface DefaultCheck<T> {

    /**
     * 预要求有效
     */
    boolean preRequirementValid(T object);

    /**
     * 获取自定义类型字段
     */
    default Map<String, String> getFieldValMap(Object obj, Check check)
            throws InvocationTargetException, IllegalAccessException, IntrospectionException
    {
        HashMap<String, String> fieldValMap = new HashMap<>();
        Class<?> clz = obj.getClass();
        PropertyDescriptor field = new PropertyDescriptor(check.field(), clz);
        fieldValMap.put(check.field(), field.getReadMethod().invoke(obj).toString());
        return fieldValMap;
    }

    /**
     * 重新添加错误提示语句
     * @param check Check 对象
     * @param constraintValidatorContext 约束验证器上下文
     * @param context 提示内容
     */
    default void reconst(
            Check check,
            ConstraintValidatorContext constraintValidatorContext,
            String context
    ) {
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(context)
                .addPropertyNode(check.field())
                .addConstraintViolation();
    }

}

