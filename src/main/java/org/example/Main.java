package org.example;

import org.example.comparator.*;
import org.example.model.Student;
import org.example.model.University;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<University> universities;
        List<Student> students;

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
    }
}