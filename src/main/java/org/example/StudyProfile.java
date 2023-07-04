package org.example;

public enum StudyProfile {
    MEDICINE("Медицина"),
    PHYSICS("Физика"),
    MATH("Математика");

    String profileName;

    public String getProfileName() {
        return profileName;
    }

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
