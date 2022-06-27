package alone.juner.demo.sqlite.model.vo;

import alone.juner.demo.sqlite.model.entity.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.Map;

/**
 * <h3>响应参数数据</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 23:27 星期日
 * @since JDK_1.8.0.271
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({})
public class DataTreeVO extends Data {
    /** 内容 */
    private List<String> context;
    /** 标签 */
    private List<String> tags;
    /** 数据列 */
    private List<Tree> list;
    /** 数据集 */
    private Map<String, Tree> map;
}
