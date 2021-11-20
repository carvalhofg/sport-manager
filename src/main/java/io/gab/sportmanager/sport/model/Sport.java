package io.gab.sportmanager.sport.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Entity
@AllArgsConstructor
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
	private Boolean isSport;
	@Lob
	@Column(name = "sportIcon")
	private byte[] sportIcon;

	public Sport(String title, String description, String groupType, Boolean isSport) {
		this.title = title;
		this.description = description;
		this.groupType = groupType;
		this.isSport = isSport;
	}

	@JsonSetter("sportIcon")
	public void setSportIcon(String sportIcon) {
		this.sportIcon = Base64.getDecoder().decode(sportIcon.getBytes(StandardCharsets.UTF_8));
	}

	public byte[] getSportIcon() {
		return sportIcon;
	}
}
