package io.gab.sportmanager.event.model;

import lombok.Getter;

@Getter
public enum EventGenderEnum {
    MALE("1"), FEMALE("2"), UNISEX("3");

    private final String id;
    EventGenderEnum(String id) {
        this.id = id;
    }
}