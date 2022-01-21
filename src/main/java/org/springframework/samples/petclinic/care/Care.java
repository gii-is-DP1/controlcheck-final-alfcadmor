package org.springframework.samples.petclinic.care;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="care")
public class Care extends BaseEntity{
	@NotNull
	@Column(name="name",unique=true)
	@Size(min=5,max=30)
    String name;
	
	
	@NotBlank
    String description;
	
	@ManyToMany(cascade= CascadeType.PERSIST)
	@NotNull
	@JoinTable(
			  name = "compatibles", 
			  joinColumns = @JoinColumn(name = "care_id"), 
			  inverseJoinColumns = @JoinColumn(name = "type_id"))
	
    Set<PetType> compatiblePetTypes;
	
	
	
	@ManyToMany(cascade= CascadeType.PERSIST)
	@JoinTable(
			  name = "incompatibles", 
			  joinColumns = @JoinColumn(name = "id_care"), 
			  inverseJoinColumns = @JoinColumn(name = "id_care_inc"))
	
	Set<Care> incompatibleCares;
	
	
	
	
	
	
}
