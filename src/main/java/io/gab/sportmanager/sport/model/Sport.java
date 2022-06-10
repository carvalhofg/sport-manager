package io.gab.sportmanager.sport.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

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
	private Boolean isSport; // Sport or E-Sport
	@Lob
	@Column(name = "sportIcon")
	private byte[] sportIcon;

	public Sport(String title, String description, String groupType, Boolean isSport) {
		this.title = title;
		this.description = description;
		this.groupType = groupType;
		this.isSport = isSport;
	}

	public void convert(@NotNull SportDTO dto) {
		Sport sport = new Sport();
		sport.setId(dto.getId());
		sport.setTitle(dto.getTitle());
		sport.setDescription(dto.getDescription());
		sport.setGroupType(dto.getGroupType());
		sport.setIsSport(dto.getIsSport());
		sport.setSportIcon(dto.getSportIcon());
	}
}
