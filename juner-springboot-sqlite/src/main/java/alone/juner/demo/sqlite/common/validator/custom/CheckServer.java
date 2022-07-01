package alone.juner.demo.sqlite.common.validator.custom;

import alone.juner.demo.sqlite.common.validator.basic.DefaultCheck;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>校验逻辑处理</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 23:00 星期日
 * @since JDK_1.8.0.271
 */
@Slf4j
public class CheckServer
        implements ConstraintValidator<Check, Object>,
        DefaultCheck<Object> {

    private Check check;

    @Override
    public void initialize(Check constraintAnnotation) {
        log.error("约束校验初始化");
        this.check = constraintAnnotation;
    }

    @SneakyThrows
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {

//        //禁用默认的message的值
//        constraintValidatorContext.disableDefaultConstraintViolation();

        log.error(obj.toString());
        log.error(constraintValidatorContext.getDefaultConstraintMessageTemplate());
        log.error(constraintValidatorContext.toString());

        //获取字段值
        Map<String, String> valMap = getFieldValMap(obj, this.check);

        if (preRequirementValid(valMap.get(check.field()))) {
            return true;
        }

        log.error("检查对象不为空： ↓ ");
        log.error(obj.toString());

        //重新添加错误提示语句
//        reconst(check, constraintValidatorContext,
//                String.format(
//                        "%s 不符合(%s)格式要求",
//                        valMap.get("certNo"), "身份证"
//                ));

        return false;
    }

    @Override
    public boolean preRequirementValid(Object object) {
        Pattern pattern = Pattern.compile(this.check.regex());
        Matcher matcher = pattern.matcher(object.toString());
        return matcher.find();
    }

}

