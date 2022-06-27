package alone.juner.demo.sqlite.utils.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>通用字符串处理</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月27日 10:39 星期一
 * @since JDK_1.8.0.271
 */
public interface GeneralString {

    /**
     * 查找匹配内容
     * @param regex 正则表达式
     * @param content 源内容
     * @return 匹配内容列
     */
    default List<String> findAll(String regex, String content) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            result.add(content.substring(matcher.start(), matcher.end()));
        }
        return result;
    }

}
