package alone.juner.demo.sqlite.controller.basic;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3>关闭服务</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 21:44 星期日
 * @since JDK_1.8.0.271
 */
@Api(tags = "关机服务")
@Controller
@RequestMapping("/server")
public class ShutdownController {
    @ApiOperation(value = "关闭服务")
    @GetMapping("/destroy")
    public void destroy() {
        System.exit(-1);
    }
}
