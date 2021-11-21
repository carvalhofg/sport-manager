package io.gab.sportmanager.sport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SportDTO {

    private Long id;
    private String title;
    private String description;
    private String groupType;
    private Boolean isSport;
    private byte[] sportIcon;

    public SportDTO(String title, String description, String groupType, Boolean isSport) {
        this.title = title;
        this.description = description;
        this.groupType = groupType;
        this.isSport = isSport;
    }
}
