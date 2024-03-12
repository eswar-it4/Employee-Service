package com.example.employee.entity;

import java.math.BigInteger;
import java.sql.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data	
@AllArgsConstructor
@NoArgsConstructor	
@Getter
@Setter
@ToString
@Table(name="employee_phonenumber")
@Entity(name = "employee_phonenumber")
public class PhoneNumber {

	@Id
	@GeneratedValue(generator = "EMPLOYEE_SEQ",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="EMPLOYEE_SEQ",sequenceName="EMPLOYEE_SEQ", allocationSize=1)	
	private int phoneid;
	
	
	@Column(name = "phonenumber")
	//@Length(min = 10,max = 12,message = "Min and max length should 10 and 12 for a phone number")
	private BigInteger phonenumber;
	
	@ManyToOne
	@JoinColumn(name = "employeeid")
	@JsonBackReference
	private Employee emp;
}
