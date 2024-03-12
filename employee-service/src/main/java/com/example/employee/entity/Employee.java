package com.example.employee.entity;

	

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(generator = "EMPLOYEE_SEQ",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="EMPLOYEE_SEQ",sequenceName="EMPLOYEE_SEQ", allocationSize=1)	
	private int employeeid;
	
	
	@Column(name = "firstname")
	@Length(min = 3,max = 10,message = "Min and max length should 3 and 10")
	private String firstname;
	
	@Column(name = "lastname")
	@Length(min = 3,max = 10,message = "Min and max length should 3 and 10")
	private String lastname;
	
	
	@Column(name = "email")
	@Length(min = 10,max = 20,message = "Min and max length should 3 and 10")
	private String email;
	
	
	@Column(name = "doj")
	@NotNull(message = "The date field should not be null")
	private Date doj;
	
	@Column(name = "salarypermonth",columnDefinition = "integer default 0")
	@Min(value = 1000,message = "The min value should be 1000")
	@Max(value = 100000000,message = "The max value should be 10000000")
	private int salarypermonth;
	
	
	
	  @JsonManagedReference 
	  @OneToMany(mappedBy = "emp",fetch = FetchType.EAGER)
	  @Cascade(CascadeType.ALL)
	  private List<PhoneNumber> phNum;
	 
	 

}
