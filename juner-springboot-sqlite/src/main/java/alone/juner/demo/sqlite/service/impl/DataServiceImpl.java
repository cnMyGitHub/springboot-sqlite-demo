package alone.juner.demo.sqlite.service.impl;

import alone.juner.demo.sqlite.mapper.DataMapper;
import alone.juner.demo.sqlite.model.basic.PageHelper;
import alone.juner.demo.sqlite.model.bo.DataBO;
import alone.juner.demo.sqlite.model.entity.Data;
import alone.juner.demo.sqlite.model.vo.DataTreeVO;
import alone.juner.demo.sqlite.service.DataService;
import alone.juner.demo.sqlite.service.basic.ICovert;
import alone.juner.demo.sqlite.service.covert.DataCovert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.tree.Tree;

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

    @Autowired
    private DataMapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(DataBO data) {
        mapper.create(DataCovert.INSTANCE.toConvert(data));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        mapper.remove(checkIsExist(mapper, id));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DataBO data) {
        mapper.update(DataCovert.INSTANCE.toConvert(data));
    }

    @Override
    public List<DataTreeVO> search(DataBO data, PageHelper pageHelper) {
        return mapper.search(DataCovert.INSTANCE.toConvert(data), pageHelper);
    }

    @Override
    public Long count(DataBO data, PageHelper pageHelper) {
        return mapper.count(DataCovert.INSTANCE.toConvert(data), pageHelper);
    }

}
