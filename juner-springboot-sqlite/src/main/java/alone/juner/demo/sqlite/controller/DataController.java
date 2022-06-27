package alone.juner.demo.sqlite.controller;

import alone.juner.demo.sqlite.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h3></h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 21:34 星期日
 * @since JDK_1.8.0.271
 */
@Controller
@RequestMapping("/")
public class DataController {

    @Autowired private DataService service;

}
