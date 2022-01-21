package org.springframework.samples.petclinic.care;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="care_provision")
public class CareProvision extends BaseEntity{   
	@NotNull
	@Min(0)
    double duration;
	
	@Column(name="visit_id",unique=false)
	@ManyToOne(optional=true)
    Visit visit;
    
	@Column(name="care_id",unique=false)
    @NotNull
    @ManyToOne(optional=false)
    Care care;   
}
