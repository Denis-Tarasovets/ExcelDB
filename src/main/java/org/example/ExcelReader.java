package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.model.Student;
import org.example.model.StudyProfile;
import org.example.model.University;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelReader {

    private static final Logger logger = Logger.getLogger(ExcelReader.class.getName());

    public static final String UNIVERSITY_PAGE = "Университеты";
    public static final int UNIVERSITY_ID_COL = 0;
    public static final int UNIVERSITY_FULLNAME_COL = 1;
    public static final int UNIVERSITY_SHORTNAME_COL = 2;
    public static final int UNIVERSITY_YEAR_COL = 3;
    public static final int UNIVERSITY_PROFILE_COL = 4;

    public static final String STUDENTS_PAGE = "Студенты";
    public static final int STUDENT_UNIVERSITY_COL = 0;
    public static final int STUDENT_FULLNAME_COL = 1;
    public static final int STUDENT_COURSE_COL = 2;
    public static final int STUDENT_SCORE_COL = 3;

    private ExcelReader() {
    }

    public static List<University> readUniversities(String filePath) {

        logger.log(Level.INFO, "Reading universities started");

        List<University> universities = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(filePath);
            XSSFSheet sheet = workbook.getSheet(UNIVERSITY_PAGE);

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                University university = new University();
                universities.add(university);
                university.setId(currentRow.getCell(UNIVERSITY_ID_COL).getStringCellValue());
                university.setFullName(currentRow.getCell(UNIVERSITY_FULLNAME_COL).getStringCellValue());
                university.setShortName(currentRow.getCell(UNIVERSITY_SHORTNAME_COL).getStringCellValue());
                university.setYearOfFoundation((int)currentRow.getCell(UNIVERSITY_YEAR_COL).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(StudyProfile.class, currentRow.getCell(UNIVERSITY_PROFILE_COL).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Reading universities error", e);
            return universities;
        }

        logger.log(Level.INFO, "Report universities ended");

        return universities;
    }

    public static List<Student> readStudents(String filePath) {

        logger.log(Level.INFO, "Reading students started");

        List<Student> students = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(filePath);
            XSSFSheet sheet = workbook.getSheet(STUDENTS_PAGE);

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(currentRow.getCell(STUDENT_UNIVERSITY_COL).getStringCellValue());
                student.setFullName(currentRow.getCell(STUDENT_FULLNAME_COL).getStringCellValue());
                student.setCurrentCourseNumber((int)currentRow.getCell(STUDENT_COURSE_COL).getNumericCellValue());
                student.setAvgExamScore((float)currentRow.getCell(STUDENT_SCORE_COL).getNumericCellValue());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Reading students error", e);
            return students;
        }

        logger.log(Level.INFO, "Report students ended");

        return students;
    }
}
