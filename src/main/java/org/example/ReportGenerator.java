package org.example;

import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.StudyProfile;
import org.example.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportGenerator {

    private ReportGenerator() {
    }

    public static List<Statistics> createReport(List<Student> students,
                                                    List<University> universities) {

        List<Statistics> report = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statistics.setProfile(profile);

            // Поиск университетов по профилю
            List<University> profileUniversity = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .collect(Collectors.toList());
            statistics.setUniversityCount(profileUniversity.size());

            // Сбор названий университетов по профилю
            String universityNames = profileUniversity.stream()
                    .map(University::getFullName)
                    .collect(Collectors.joining(", "));
            statistics.setUniversityNames(universityNames);

            List<String> universityIds = profileUniversity.stream()
                    .map(University::getId)
                    .collect(Collectors.toList());

            // Отбор студентов университетов по профилю университетов
            List<Student> profileStudents = students.stream()
                    .filter(student -> universityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setStudentCount(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(4, RoundingMode.HALF_UP).doubleValue()));

            report.add(statistics);
        });

        return report;
    }
}
