package alone.juner.demo.sqlite.model.basic;

import alone.juner.demo.sqlite.common.validator.custom.Check;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <h3>分页助手</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description 链式编程
 * @date 2022年06月26日 23:25 星期日
 * @since JDK_1.8.0.271
 */
@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PageHelper {

    private Long limit;
    private Long page;

    private Long totalCount;
    private Long totalPages;

    private String filed;
    @Check(regex = "1|-1", field = "order")
    private Byte order;

    public Number getPage() {
        if(null != this.page){
            return (this.page - 1) * limit;
        }
        return null;
    }

    public Number getTotalPages() {
        if(null != this.totalPages){
            return this.totalPages % this.limit == 0
                    ? this.totalPages / this.limit
                    : (this.totalPages / this.limit) + 1;
        }
        return null;
    }
}
