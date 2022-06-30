package alone.juner.demo.sqlite.utils.docx;

import com.deepoove.poi.XWPFTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

/**
 * <h3>Word 工具</h3><hr/>
 *
 * @author Juner
 * @version 0.0.35
 * @description
 * @date 2022年06月29日 14:07 星期三
 * @since JDK_1.8.0.271
 */
@Slf4j
public class WordUtils {

    private static final String COPY_ROW_INDEX = "copyRowIndex";
    private static final String TABLE_INDEX = "tableIndex";

    /**
     * 创建普通模板文档
     *
     * @param templateFilePath 模版文件名
     * @param outputPath       输出文件名
     * @param map              数据
     */
    @SuppressWarnings("unused")
    public static void createDocument(
            String templateFilePath,
            String outputPath,
            Map<String, Object> map
    ) throws IOException {
        usageTemplate(templateFilePath, outputPath, map);
    }

    /**
     * 创建扩展表格文档
     *
     * @param templateFilePath 模版文件名
     * @param outputPath       输出文件名
     * @param map              模版基本数据
     * @param extendMap        扩展数据
     */
    @SuppressWarnings("unused")
    public static void createTableWithExtend(
            String templateFilePath,
            String outputPath,
            Map<String, Object> map,
            LinkedHashMap<String, List<String>> extendMap
    ) throws IOException {
        usageTemplate(templateFilePath, outputPath, map);

        Map<String, Integer> params = new HashMap<>();
        // 复制第一行，并随后插入新行，写入数据
        params.put(COPY_ROW_INDEX, 0);
        // 使用第一个表格
        params.put(TABLE_INDEX, 0);

        extendData(outputPath, params, extendMap);
    }

    /**
     * 使用 模板 写入
     *
     * @param templateFilePath 模板路径
     * @param outputFilePath   输出文件路径
     * @param map              数据
     */
    private static void usageTemplate(
            String templateFilePath,
            String outputFilePath,
            Map<String, Object> map
    ) throws IOException {
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        XWPFTemplate template = XWPFTemplate.compile(templateFilePath).render(map);
        template.writeAndClose(new FileOutputStream(outputFilePath));
    }

    /**
     * 扩展表格数据
     *
     * @param outputFilePath 输出文件路径
     * @param extendMap      扩展数据
     */
    private static void extendData(
            String outputFilePath,
            Map<String, Integer> params,
            LinkedHashMap<String, List<String>> extendMap
    ) throws IOException {
        if (extendMap != null) {
            XWPFDocument document = new XWPFDocument(new FileInputStream(outputFilePath));
            FileOutputStream out = new FileOutputStream(outputFilePath);

            insertNewRow(
                    document,
                    out,
                    params,
                    extendMap
            );
        }
    }

    /**
     * 拆字
     *
     * @param context 预拆内容
     * @return 拆解为List
     */
    private static List<String> wordBreakUp(String context) {
        List<String> result = new ArrayList<>();
        for (char c : context.toCharArray()) {
            result.add(String.valueOf(c));
        }
        return result;
    }

    /**
     * 插入新行并写入数据
     *
     * @param document  文档
     * @param out       输出流
     * @param params    操作参数
     * @param extendMap 扩展数据
     */
    private static void insertNewRow(
            XWPFDocument document,
            FileOutputStream out,
            Map<String, Integer> params,
            LinkedHashMap<String, List<String>> extendMap
    ) throws IOException {
        XWPFTable table = document.getTables().get(params.get(TABLE_INDEX));
        long startTime = System.nanoTime();

        int targetIndex = 0;
        for (String k : extendMap.keySet()) {
            List<String> v = extendMap.get(k);
            if (k != null) {
                copyNewRow(table, params.get(COPY_ROW_INDEX), (params.get(COPY_ROW_INDEX) + targetIndex));
                XWPFTableRow row = table.getRow(targetIndex);
                applySoftReturn(row, 0, ParagraphAlignment.CENTER, wordBreakUp(k), true);
                if (v != null && v.size() > 0) {
                    applySoftReturn(row, 1, ParagraphAlignment.LEFT, v, false);
                }
                targetIndex++;
            }
        }

        document.write(out);
        Duration timeTakenToStartup = Duration.ofNanos(System.nanoTime() - startTime);
        log.info("{} {} {}", "Write Extend Data in ", ((double)timeTakenToStartup.toMillis() / 1000.0D), " seconds");

        out.flush();
        out.close();
    }

    /**
     * 插入表格行 在word表格中指定位置插入一行，并将某一行的样式复制到新增行
     *
     * @param table        表格对象
     * @param copyrowIndex 需要复制的行位置
     * @param newrowIndex  需要新增一行的位置
     */
    private static void copyNewRow(
            XWPFTable table,
            int copyrowIndex,
            int newrowIndex
    ) {
        if (copyrowIndex == newrowIndex) {
            return;
        }
        XWPFTableRow targetRow = table.insertNewTableRow(newrowIndex);
        XWPFTableRow copyRow = table.getRow(copyrowIndex);
        targetRow.getCtRow().setTrPr(copyRow.getCtRow().getTrPr());
        List<XWPFTableCell> copyCells = copyRow.getTableCells();
        XWPFTableCell targetCell;
        for (XWPFTableCell copyCell : copyCells) {
            targetCell = targetRow.addNewTableCell();
            targetCell.getCTTc().setTcPr(copyCell.getCTTc().getTcPr());
            if (copyCell.getParagraphs() != null && copyCell.getParagraphs().size() > 0) {
                targetCell.getParagraphs().get(0).getCTP().setPPr(copyCell.getParagraphs().get(0).getCTP().getPPr());
                if (copyCell.getParagraphs().get(0).getRuns() != null
                        && copyCell.getParagraphs().get(0).getRuns().size() > 0) {
                    XWPFRun cellR = targetCell.getParagraphs().get(0).createRun();
                    cellR.setBold(copyCell.getParagraphs().get(0).getRuns().get(0).isBold());
                }
            }
        }
    }

    /**
     * 表格内，使用软回车写入内容
     *
     * @param row       行内容
     * @param cellIndex 列索引
     * @param context   List 字符串内容
     */
    private static void applySoftReturn(
            XWPFTableRow row,
            Integer cellIndex,
            ParagraphAlignment paragraphAlignment,
            List<String> context,
            Boolean colorFlag
    ) throws IOException {
        if (row.getCell(cellIndex) == null) {
            throw new IOException();
        }
        XWPFParagraph para = row.getCell(cellIndex).getParagraphs().get(0);
        para.setAlignment(paragraphAlignment);
        if (context != null) {
            for (String text : context) {
                XWPFRun run = para.createRun();
                run.setText(text.trim());
                run.addBreak(BreakClear.ALL);
                run.setFontFamily("宋体");
                run.setFontSize(12);
                if (colorFlag) {
                    run.setColor("1F497D");
                } else {
                    run.addCarriageReturn();
                    run.addCarriageReturn();
                }
            }
        }
    }

}

