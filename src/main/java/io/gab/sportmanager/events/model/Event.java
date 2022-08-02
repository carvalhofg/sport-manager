package io.gab.sportmanager.events.model;

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
    @Column(name = "eventIcon")
    private byte[] eventIcon;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private String place;

    @NotNull
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "specs_id")
    private EventSpecs specs;

}
