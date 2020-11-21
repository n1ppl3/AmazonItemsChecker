package ru.n1ppl3.amazon.items.checker.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import ru.n1ppl3.amazon.items.checker.dto.AmazonExcelRow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * explained in https://www.baeldung.com/java-microsoft-excel
 */
@Slf4j
public abstract class AmazonExcelParser {

    private static final Predicate<String> isAmazonUrl = s -> StringUtils.hasText(s) && s.contains("http") && s.contains("amazon");

    /**
     * парсит заданный xls файл, находя в нём ссылки на item'ы с Амазона
     */
    public static List<AmazonExcelRow> parseExcelFile(Resource pathToExcelFile) throws IOException {
        logger.info("Gonna parse {}", pathToExcelFile);
        try (Workbook workbook = new XSSFWorkbook(pathToExcelFile.getInputStream())) {
            return parseWorkbook(workbook);
        }
    }

    private static List<AmazonExcelRow> parseWorkbook(Workbook workbook) {
        List<AmazonExcelRow> result = new ArrayList<>();
        for (Sheet sheet : workbook) {
            logger.info("Gonna parse '{}'", sheet.getSheetName());
            List<AmazonExcelRow> values = parseSheet(sheet);
            logger.info("Found {} value(s) in sheet '{}", values.size(), sheet.getSheetName());
            result.addAll(values);
        }
        return result;
    }

    private static List<AmazonExcelRow> parseSheet(Sheet sheet) {
        List<AmazonExcelRow> result = new ArrayList<>();
        for (Row row : sheet) {
            for (Cell cell : row) {
                String cellValue = getCellValue(cell);
                if (isAmazonUrl.test(cellValue)) {
                    result.add(new AmazonExcelRow(cellValue));
                }
            }
        }
        return result;
    }

    private static @Nullable String getCellValue(Cell cell) {
        if (cell.getCellType().equals(CellType.STRING)) {
            return cell.getStringCellValue();
        }
        return null;
    }
}
