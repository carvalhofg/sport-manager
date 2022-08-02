package io.gab.sportmanager.sport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Sport {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private String groupType;
	private Boolean isSport; // Sport or E-Sport
	@Lob
	@Column(name = "sportIcon")
	private byte[] sportIcon;

	public Sport(String title, String description, String groupType, Boolean isSport, byte[] sportIcon) {
		this.title = title;
		this.description = description;
		this.groupType = groupType;
		this.isSport = isSport;
		this.sportIcon = sportIcon;
	}
}
