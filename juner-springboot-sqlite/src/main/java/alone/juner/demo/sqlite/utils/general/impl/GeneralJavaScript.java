package alone.juner.demo.sqlite.utils.general.impl;

import alone.juner.demo.sqlite.utils.general.GeneralUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * <h3>通用运行 Javascript 处理</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月27日 10:49 星期一
 * @since JDK_1.8.0.271
 */
public interface GeneralJavaScript {

    default String startJavascript(String content) throws IOException, ScriptException {
        ScriptEngineManager m = new ScriptEngineManager();
        ScriptEngine engine = m.getEngineByName("JavaScript");
        PipedReader prd = new PipedReader();
        PipedWriter pwt = new PipedWriter(prd);

        engine.getContext().setWriter(pwt);
        engine.eval(content);
        BufferedReader br = new BufferedReader(prd);

        String str = null;
        while ((str = br.readLine()) != null && str.length() > 0) {
            GeneralUtils.logger.debug("输出： \"" + str + "\"");
            str += str;
        }
        br.close();
        pwt.close();
        prd.close();
        if(str == null) {
            return null;
        }
        return str.trim();
    }

}
