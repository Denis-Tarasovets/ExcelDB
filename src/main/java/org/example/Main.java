package org.example;

public class Main {
    public static void main(String[] args) {
        University university1 = new University("ЯРГУ", "Ярославский Государственный Университет", "ЯРГУ", 1970, StudyProfile.MEDICINE);
        Student student1 = new Student("Василий Иванович Пупкин", "ЯРГУ", 5, 5);

        System.out.println(university1);
        System.out.println(student1);
    }
}