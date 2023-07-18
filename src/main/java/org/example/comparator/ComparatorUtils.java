package org.example.comparator;

public class ComparatorUtils {
    private ComparatorUtils() {
    }

    public static UniversityComparator getUniversityComparator(UniversityCompareField compareField) {
        switch (compareField) {
            case UNIVERSITY_ID:
                return new UniversityUniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityFoundationYearComparator();
            case MAIN_PROFILE:
                return new UniversityProfileComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }

    public static StudentComparator getStudentComparator(StudentCompareField compareField) {
        switch (compareField) {
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case CURRENT_COURSE_NUMBER:
                return new StudentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }
}
