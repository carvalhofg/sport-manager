package io.gab.sportmanager.sport.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sport")
public class Sport {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "group_type")
	private String groupType;
	@Column(name = "is_sport")
	@NotNull
	private Boolean isSport; // Sport or E-Sport
	@Lob
	@Column(name = "sport_icon")
	private byte[] sportIcon;

	public Sport(String title, String description, String groupType, Boolean isSport, byte[] sportIcon) {
		this.title = title;
		this.description = description;
		this.groupType = groupType;
		this.isSport = isSport;
		this.sportIcon = sportIcon;
	}
}
