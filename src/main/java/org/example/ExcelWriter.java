package org.example;

import org.apache.poi.xssf.usermodel.*;
import org.example.model.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelWriter {

    private static final Logger logger = Logger.getLogger(ExcelWriter.class.getName());

    public static final String STATISTIC_PAGE_NAME = "Статистика";
    public static final int HEADER_ROW = 1;
    private static final int PROFILE_COL = 1;
    public static final String PROFILE_COL_NAME = "Профиль";
    private static final int AVG_EXAM_SCORE_COL = 2;
    public static final String AVG_EXAM_SCORE_COL_NAME = "Средний балл";
    private static final int STUDENT_COUNT_COL = 3;
    public static final String STUDENT_COUNT_COL_NAME = "Кол-во студентов";
    private static final int UNIVERSITY_COUNT_COL = 4;
    public static final String UNIVERSITY_COUNT_COL_NAME = "Кол-во университетов";
    private static final int UNIVERSITY_NAMES_COL = 5;
    public static final String UNIVERSITY_NAMES_COL_NAME = "Названия университетов";
    private ExcelWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList, String filePath)  {

        logger.log(Level.INFO, "Export statistic started");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(STATISTIC_PAGE_NAME);
        XSSFRow headerRow = sheet.createRow(HEADER_ROW);
        XSSFCell cell;
        XSSFRow curRow;

        XSSFCellStyle headerStyle = workbook.createCellStyle();
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerStyle.setFont(headerFont);

        cell = headerRow.createCell(PROFILE_COL);
        cell.setCellStyle(headerStyle);
        cell.setCellValue(PROFILE_COL_NAME);

        cell = headerRow.createCell(AVG_EXAM_SCORE_COL);
        cell.setCellStyle(headerStyle);
        cell.setCellValue(AVG_EXAM_SCORE_COL_NAME);

        cell = headerRow.createCell(STUDENT_COUNT_COL);
        cell.setCellStyle(headerStyle);
        cell.setCellValue(STUDENT_COUNT_COL_NAME);

        cell = headerRow.createCell(UNIVERSITY_COUNT_COL);
        cell.setCellStyle(headerStyle);
        cell.setCellValue(UNIVERSITY_COUNT_COL_NAME);

        cell = headerRow.createCell(UNIVERSITY_NAMES_COL);
        cell.setCellStyle(headerStyle);
        cell.setCellValue(UNIVERSITY_NAMES_COL_NAME);

        int rowNum = 1;
        for (Statistics statistics : statisticsList) {
            rowNum += 1;
            curRow = sheet.createRow(rowNum);
            cell = curRow.createCell(PROFILE_COL);
            cell.setCellValue(statistics.getProfile().getProfileName());
            sheet.autoSizeColumn(PROFILE_COL);

            cell = curRow.createCell(AVG_EXAM_SCORE_COL);
            cell.setCellValue(statistics.getAvgExamScore());
            sheet.autoSizeColumn(AVG_EXAM_SCORE_COL);

            cell = curRow.createCell(STUDENT_COUNT_COL);
            cell.setCellValue(statistics.getStudentCount());
            sheet.autoSizeColumn(STUDENT_COUNT_COL);

            cell = curRow.createCell(UNIVERSITY_COUNT_COL);
            cell.setCellValue(statistics.getUniversityCount());
            sheet.autoSizeColumn(UNIVERSITY_COUNT_COL);

            cell = curRow.createCell(UNIVERSITY_NAMES_COL);
            cell.setCellValue(statistics.getUniversityNames());
            sheet.autoSizeColumn(UNIVERSITY_NAMES_COL);
        }

        try {
            OutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error on export statistic to excel file", e);
        }

        logger.log(Level.INFO, "Export statistic ended");
    }
}
