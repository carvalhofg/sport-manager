package io.gab.sportmanager.event.model;

import io.gab.sportmanager.sport.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @Column(name = "event_icon")
    private byte[] eventIcon;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "place")
    private String place;

    @NotNull
    @Column(name = "date")
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "specs_id")
    private EventSpecs specs;

}
