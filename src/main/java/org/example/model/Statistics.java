package org.example.model;

public class Statistics {
    private StudyProfile profile;
    private float avgExamScore;
    private int studentCount;
    private int universityCount;
    private String universityNames;
    public StudyProfile getProfile() {
        return profile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public String getUniversityNames() {
        return universityNames;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public Statistics setStudentCount(int studentCount) {
        this.studentCount = studentCount;
        return this;
    }

    public Statistics setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
        return this;
    }

    public Statistics setUniversityNames(String universityNames) {
        this.universityNames = universityNames;
        return this;
    }

    public Statistics(StudyProfile profile, float avgExamScore, int studentCount, int universityCount, String universityNames) {
        this.profile = profile;
        this.avgExamScore = avgExamScore;
        this.studentCount = studentCount;
        this.universityCount = universityCount;
        this.universityNames = universityNames;
    }

    public Statistics() {
        this(null, 0, 0, 0, "");
    }
}
