package alone.juner.demo.sqlite.controller;

import alone.juner.demo.sqlite.common.request.GlobalResponse;
import alone.juner.demo.sqlite.common.validator.crud.Update;
import alone.juner.demo.sqlite.model.basic.PageHelper;
import alone.juner.demo.sqlite.model.bo.DataBO;
import alone.juner.demo.sqlite.service.DataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <h3>数据控制器</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 21:34 星期日
 * @since JDK_1.8.0.271
 */
@Api(tags = "主要数据")
@RestController
@RequestMapping("/")
public class DataController {

    @Autowired private DataService service;

    @GetMapping("/search/body")
    @SuppressWarnings("rawtypes")
    public GlobalResponse searchRequestBody(
            @RequestBody DataBO dataBO,
            @RequestBody PageHelper pageHelper
    ) {
        return GlobalResponse
                .of(service.search(dataBO, pageHelper));
    }

    @GetMapping("/search")
    @SuppressWarnings("rawtypes")
    public GlobalResponse search(
            DataBO dataBO,
            PageHelper pageHelper
    ) {
        return GlobalResponse
                .of(service.search(dataBO, pageHelper));
    }

    @GetMapping("/count")
    @SuppressWarnings("rawtypes")
    public GlobalResponse count(
            DataBO dataBO,
            PageHelper pageHelper
    ) {
        return GlobalResponse
                .success()
                .setLimit(pageHelper.getLimit())
                .setTotalCount(service.count(dataBO, pageHelper));
    }

    @PostMapping("/save")
    @SuppressWarnings("rawtypes")
    public GlobalResponse create(
            @RequestBody DataBO dataBO
    ) {
        service.create(dataBO);
        return GlobalResponse.success();
    }

    @PutMapping("/update")
    @SuppressWarnings("rawtypes")
    public GlobalResponse update(
            @RequestBody @Validated(Update.class) DataBO dataBO) {
        service.create(dataBO);
        return GlobalResponse.success();
    }

    @ApiOperation("删除数据")
    @ApiImplicitParam(name = "id", value = "数据ID", required = true, dataType = "Integer", paramType = "delete")
    @DeleteMapping("/remove/{id}")
    @SuppressWarnings("rawtypes")
    public GlobalResponse delete(
            @PathVariable Long id
    ) {
        service.remove(id);
        return GlobalResponse.success();
    }

}
