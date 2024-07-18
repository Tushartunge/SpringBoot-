package com.anudip.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    
    @Column(length = 20, nullable = false)
    private String deptName;
    
    @Column(length = 20, nullable = false)
    private String deptHOD;

    private int noofEmp;
    
    @OneToMany(mappedBy = "department",  
    		fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    		@JsonManagedReference
    		List<Teacher> teacherList;

//	public int getDid() {
//		return did;
//	}
//
//	public void setDid(int did) {
//		this.did = did;
//	}
//
//	public String getDeptName() {
//		return deptName;
//	}
//
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
//
//	public String getDeptHOD() {
//		return deptHOD;
//	}
//
//	public void setDeptHOD(String deptHOD) {
//		this.deptHOD = deptHOD;
//	}
//
//	public int getNoofEmp() {
//		return noofEmp;
//	}
//
//	public void setNoofEmp(int noofEmp) {
//		this.noofEmp = noofEmp;
//	}
//
//	public Department(int did, String deptName, String deptHOD, int noofEmp) {
//		super();
//		this.did = did;
//		this.deptName = deptName;
//		this.deptHOD = deptHOD;
//		this.noofEmp = noofEmp;
//	}
//
//	public Department() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Department [did=" + did + ", deptName=" + deptName + ", deptHOD=" + deptHOD + ", noofEmp=" + noofEmp
//				+ "]";
//	} 
//    
    
}
