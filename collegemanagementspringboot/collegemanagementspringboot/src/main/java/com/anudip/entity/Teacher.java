package com.anudip.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Teacher
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	@Column(length=25, nullable = false)
	@NotBlank(message="Teacher name can not be blank..") // validation
	private String tname;
	
	@Column(length=25,nullable = false)
	@NotBlank(message="Trainer surname name can not be blank..") // validation
	private String tsurname;
	
	@Column(length=25,nullable = false, unique=true)
	@NotBlank(message="Trainer email can not be blank..") // validation
	@Email(message="Email id is not proper")
	private String temail;
	
	@Column(length=25,nullable = false, unique=true)
	@NotBlank(message="Phone Number can not be blank..") // validation
	private String tphone;
	
	@Column(length=25,nullable = false)
	@NotBlank(message="Designation can not be blank..") // validation
	private String designation;
	
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="deptID", referencedColumnName = "did")
	@JsonBackReference
	private Department department;

	@OneToMany(mappedBy = "teacher",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Batches> batcheDetails;
	
	
}
