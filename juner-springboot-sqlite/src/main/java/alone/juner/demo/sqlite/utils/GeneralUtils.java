package alone.juner.demo.sqlite.utils;

import alone.juner.demo.sqlite.utils.impl.GeneralJavaScript;
import alone.juner.demo.sqlite.utils.impl.GeneralString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h3>通用工具箱</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description 使用饿汉式声明
 * @date 2022年06月27日 10:38 星期一
 * @since JDK_1.8.0.271
 */
public class GeneralUtils
        implements
                GeneralString,
                GeneralJavaScript
{

    public static final Logger logger =
            LoggerFactory.getLogger(GeneralUtils.class);

    private static final GeneralUtils GENERAL_UTILS = new GeneralUtils();

    public static GeneralUtils build() {
        return GENERAL_UTILS;
    }

}
