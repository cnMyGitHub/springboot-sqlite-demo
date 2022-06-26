package alone.juner.demo.sqlite.config.sqlite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * <h3>SQLite 初始化</h3><hr/>
 *
 * @author Juner
 * @version 0.0.1
 * @description
 * @date 2022年06月26日 20:06 星期日
 * @since JDK_1.8.0.271
 */
@Configuration
public class SqliteGenerator {
    private static final Logger logger =
            LoggerFactory.getLogger(SqliteGenerator.class);

    private static final String QUERY_TABLE_INFOS = "select count(*) from sqlite_master where type='table'";

    private static final String THIS_DEBUG_PRE = "【debugger】 SqliteGenerator - ";

    private static final String TABLE_NAME = "data";

    /**
     * 获取文件所在路径
     * 连接必须以 prefix 为前缀开头
     * @param url 文件连接
     * @return 文件所在路径
     */
    private String getFilePath(String url){
        final String prefix = "jdbc:sqlite:";
        url = url.replace(prefix, "");
        return url;
    }

    /**
     * 初始化文件（先初始化文件）
     * @param filePath 文件路径
     */
    public void initFile(String filePath){

        logger.debug("{} 初始化数据文件.", THIS_DEBUG_PRE);

        filePath = getFilePath(filePath);
        logger.debug("{} {} {}.", THIS_DEBUG_PRE, "路径 > ",filePath);

        File file = new File(filePath);
        File dir = file.getParentFile();
        if(!dir.exists()){
            logger.debug("{} {}.", THIS_DEBUG_PRE, "准备创建文件夹");
            boolean folderStatus = dir.mkdirs();
            if(!folderStatus) {
                logger.error("{} {}.", THIS_DEBUG_PRE, "创建文件夹失败，请检查路径或权限");
                throw new RuntimeException("folder create failed.");
            }
        }

        if(!file.exists()){
            logger.debug("{} {}.", THIS_DEBUG_PRE, "准备创建文件");
            try {
                boolean fileStatus = file.createNewFile();
                if(!fileStatus) {
                    logger.error("{} {}.", THIS_DEBUG_PRE, "创建文件失败，请检查路径或权限");
                    throw new RuntimeException("file create failed.");
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    /**
     * 初始化数据库
     * @param connection 连接
     * @param sqls SQL文
     */
    private void initDatabase(Connection connection, List<String> sqls){
        logger.debug("{} 准备初始化数据库: {}", THIS_DEBUG_PRE, sqls);
        try {
            for(String str:sqls) {
                connection.setAutoCommit(false);
                connection.prepareStatement(str).execute();
            }
            connection.commit();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
        logger.debug("{} 数据库初始化已完成>>>", THIS_DEBUG_PRE);
    }

    /**
     * 读取脚本文件
     * 读取初始化的SQL，如果未配置，则读取默认配置
     * @return SQL 文集
     */
    private List<String> readScriptFile() {
        File file = null;
        try {
            String script = "classpath:sql/init.sql";
            file = ResourceUtils.getFile(script);
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage(), e);
        }
        return getInitSql(file);
    }

    /**
     * 获取初始化 SQL 文
     * @return SQL文集
     */
    private List<String> getInitSql(File file) {
        String sql = "";
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader bf = new BufferedReader(isr);
            String content = "";
            StringBuilder sb = new StringBuilder();
            while(true) {
                content = bf.readLine();
                if (content == null) {
                    break;
                }
                if (content.contains("【tableName】")) {
                    content = content.replace("【tableName】", TABLE_NAME);
                }
                sb.append(content.trim());
            }
            sql = sb.toString();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                assert isr != null;
                isr.close();
                fis.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return Arrays.asList(sql.split(";"));
    }

    /**
     * 初始化表
     * 创建伪连接判断是否存在数据库文件，不存在则创建数据库并初始化表
     * @param connection 连接
     */
    public void initTable(Connection connection){
        boolean hasDatabase = true, hasTable = true;
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_TABLE_INFOS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int total = resultSet.getInt(1);
                if (total == 0) {
                    hasTable = false;
                    logger.debug("{} 数据表不存在", THIS_DEBUG_PRE);
                } else {
                    logger.debug("{} 数据表已存在", THIS_DEBUG_PRE);
                }
            }
        }catch (SQLException e){
            logger.debug("{} 数据表不存在，准备创建", THIS_DEBUG_PRE);
            hasDatabase = false;
        }

        if(hasDatabase && !hasTable) {
            logger.debug("{} 准备初始化数据库", THIS_DEBUG_PRE);
            initDatabase(connection, readScriptFile());
            logger.debug("{} 初始化数据库完成 <<<", THIS_DEBUG_PRE);
        }else {
            logger.debug("{} 数据库及数据表已存在", THIS_DEBUG_PRE);
        }
    }
}
