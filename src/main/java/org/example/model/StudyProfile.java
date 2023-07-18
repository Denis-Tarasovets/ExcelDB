package org.example.model;

public enum StudyProfile {
    PHYSICS("PHYSICS"),
    MEDICINE("MEDICINE"),
    LINGUISTICS("LINGUISTICS"),
    MATHEMATICS("MATHEMATICS");

    String profileName;

    public String getProfileName() {
        return profileName;
    }

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }
}
