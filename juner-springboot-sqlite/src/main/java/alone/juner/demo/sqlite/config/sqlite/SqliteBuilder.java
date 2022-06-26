package alone.juner.demo.sqlite.config.sqlite;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.sqlite.JDBC;

import javax.sql.DataSource;

/**
 * <h3>SQLite 实例</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 20:06 星期日
 * @since JDK_1.8.0.271
 */
public class SqliteBuilder {
    private String filePath;
    private String url;

    /**
     * 创建一个 SQLite 实例
     */
    public static SqliteBuilder create(){
        return  new SqliteBuilder();
    }

    public SqliteBuilder filePath(String filePath){
        this.filePath =filePath;
        return this;
    }

    public SqliteBuilder url(String url) {
        this.url = url;
        return this;
    }

    public DataSource build(){
        if (url!=null&& !"".equals(url)){
            return DataSourceBuilder.create().
                    url(url).driverClassName(JDBC.class.getName()).build();
        }
        if(filePath!=null&& !"".equals(filePath)){
            StringBuilder stringBuilder =  new StringBuilder();
            stringBuilder.append("jdbc:sqlite:").append(filePath);
            return DataSourceBuilder.create().
                    url(stringBuilder.toString()).driverClassName(JDBC.class.getName()).build();
        }
        return DataSourceBuilder.create().build();
    }
}
