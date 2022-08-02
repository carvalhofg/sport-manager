package io.gab.sportmanager.events.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "event_specs")
@Getter
@Setter
public class EventSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
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