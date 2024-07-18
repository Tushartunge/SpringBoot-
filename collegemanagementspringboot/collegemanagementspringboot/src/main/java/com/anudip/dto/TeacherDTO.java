package com.anudip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
	
	private int tid;
	
	private String tsurname;
	
	private String temail;
	
	private String tphone;
	
	private String designation;

}
