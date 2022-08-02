package io.gab.sportmanager.events.model;

public enum Gender {
    MALE("1"), FEMALE("2"), UNISEX("3");

    private final String gender;
    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() { return gender; }
}