package io.gab.sportmanager.events.model;

import io.gab.sportmanager.sport.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sport_id")
    private Sport sport;

    @Lob
    @Column(name = "eventIcon")
    private byte[] eventIcon;

    private String name;
    private String description;
    private String local;
    private LocalDateTime date;
    private String groupType;
    private Integer groupLimit;
    private Integer minimumGroupSize;
    private Integer maximumGroupSize;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer minimumAge;
    private Integer maximumAge;
    private String prize;
    private Long joinPrice;
    private String details;
}
