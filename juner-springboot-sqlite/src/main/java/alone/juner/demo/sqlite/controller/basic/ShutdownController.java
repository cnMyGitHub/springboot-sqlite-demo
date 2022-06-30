package alone.juner.demo.sqlite.controller.basic;

import alone.juner.demo.sqlite.common.request.GlobalResponse;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <h3>关闭服务</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 21:44 星期日
 * @since JDK_1.8.0.271
 */
@ApiSupport(author = "xiaoymin@foxmail.com", order = 284)
@Api(tags = "关机服务")
@Controller
@RequestMapping("/server")
public class ShutdownController {

    @ApiOperationSupport(author = "1530620364@qq.com")
    @ApiOperation(value = "测试服务")
    @GetMapping("/")
    @ResponseBody
    @SuppressWarnings("rawtypes")
    public GlobalResponse success() {
        return GlobalResponse.success();
    }

    @ApiOperation(
            value = "关闭服务",
            hidden = true
    )
    @GetMapping("/destroy")
    public void destroy() {
        System.exit(-1);
    }
}
