package org.example;

import org.example.comparator.*;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.model.XmlStudInfo;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        logger.log(Level.INFO, "Application started");

        List<University> universities;
        List<Student> students;
        XmlStudInfo  studInfo;

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        universities = ExcelReader.readUniversities("src/main/resources/universityInfo.xlsx");
        students = ExcelReader.readStudents("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorUtils.getUniversityComparator(UniversityCompareField.FULL_NAME);
        StudentComparator studentComparator = ComparatorUtils.getStudentComparator(StudentCompareField.FULL_NAME);

        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);

        List<Statistics> statisticsList = ReportGenerator.createReport(students, universities);
        ExcelWriter.writeXlsStatistics(statisticsList, "src/main/resources/report.xlsx");

        studInfo = new XmlStudInfo()
                .setUniversityList(universities)
                .setStudentList(students)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.exportXML(studInfo, "src/main/resources/report.xml");

        logger.log(Level.INFO, "Application ended");
    }
}