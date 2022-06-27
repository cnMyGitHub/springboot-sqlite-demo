package alone.juner.demo.sqlite.service.impl;

import alone.juner.demo.sqlite.model.basic.PageHelper;
import alone.juner.demo.sqlite.model.bo.DataBO;
import alone.juner.demo.sqlite.model.vo.DataTreeVO;
import alone.juner.demo.sqlite.service.DataService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3>数据服务实现</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 19:49 星期日
 * @since JDK_1.8.0.271
 */
@Service
public class DataServiceImpl
        implements DataService
{

    @Override
    public void create(DataBO data) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(DataBO data) {

    }

    @Override
    public List<DataTreeVO> search(DataBO data, PageHelper pageHelper) {
        return null;
    }

    @Override
    public Long count(DataBO data, PageHelper pageHelper) {
        return null;
    }

}
