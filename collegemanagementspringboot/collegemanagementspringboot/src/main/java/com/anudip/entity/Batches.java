package com.anudip.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="Batch_details")
public class Batches
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Batch Name cannot be blank")
	private String bname;
	
	@Column(length=25, nullable = false)
	@NotBlank(message = "Subject Name cannot be blank")
	private String subject;
	
	@Column(length=25, nullable = false)
	private String startdate;
	
	@Column(length=25, nullable = false)
	private String enddate;
	
	private int duration;
	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="TeacherId", referencedColumnName = "tid")
	@JsonBackReference
	private Teacher teacher;
//	public Batches() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Batches(int bid, @NotBlank(message = "Batch Name cannot be blank") String bname,
//			@NotBlank(message = "Subject Name cannot be blank") String subject, String startdate, String enddate,
//			int duration) {
//		super();
//		this.bid = bid;
//		this.bname = bname;
//		this.subject = subject;
//		this.startdate = startdate;
//		this.enddate = enddate;
//		this.duration = duration;
//	}
//
//	public int getBid() {
//		return bid;
//	}
//
//	public void setBid(int bid) {
//		this.bid = bid;
//	}
//
//	public String getBname() {
//		return bname;
//	}
//
//	public void setBname(String bname) {
//		this.bname = bname;
//	}
//
//	public String getSubject() {
//		return subject;
//	}
//
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//
//	public String getStartdate() {
//		return startdate;
//	}
//
//	public void setStartdate(String startdate) {
//		this.startdate = startdate;
//	}
//
//	public String getEnddate() {
//		return enddate;
//	}
//
//	public void setEnddate(String enddate) {
//		this.enddate = enddate;
//	}
//
//	public int getDuration() {
//		return duration;
//	}
//
//	public void setDuration(int duration) {
//		this.duration = duration;
//	}
//
//	@Override
//	public String toString() {
//		return "Batches [bid=" + bid + ", bname=" + bname + ", subject=" + subject + ", startdate=" + startdate
//				+ ", enddate=" + enddate + ", duration=" + duration + "]";
//	}
//	
	
}
