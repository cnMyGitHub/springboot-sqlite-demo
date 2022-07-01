package alone.juner.demo.sqlite.config.datasource;

import alone.juner.demo.sqlite.config.sqlite.SqliteBuilder;
import alone.juner.demo.sqlite.config.sqlite.SqliteGenerator;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * <h3>SQLite 配置</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 21:31 星期日
 * @since JDK_1.8.0.271
 */
@MapperScan(
        basePackages = {
                "alone.juner.demo.sqlite.mapper"
        }, sqlSessionFactoryRef = "sqlSessionFactory"
)
@Setter
@Getter
@Configuration
public class SqliteConfig {

    @Value("${system.file: jdbc:sqlite:search-lib.db}")
    private String dataSourceUrl;

    @Autowired
    private SqliteGenerator sqliteGenerator;

    private static final Logger logger =
            LoggerFactory.getLogger(SqliteConfig.class);

    /**
     * 配置sqlite数据源
     */
    @Bean(name = "sqliteDataSource")
    public DataSource sqliteDataSource(){
        sqliteGenerator.initFile(dataSourceUrl);
        DataSource dataSource  = SqliteBuilder.create().url(dataSourceUrl).build();
        try {
            sqliteGenerator.initTable(dataSource.getConnection());
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return dataSource;
    }


    /**
     * session工厂
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("dynamicDataSource") DynamicDataSource dataSource
    ) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().
                        getResources("classpath:mapper/**/*.xml"));
        return sessionFactoryBean.getObject();

    }

    /**
     * session模板
     */
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate comSqlSessionTemplate(
            @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory
    ) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 动态数据源
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(
            @Qualifier("sqliteDataSource") DataSource dataSource
    ){
        return  new DynamicDataSource(dataSource);
    }
}
