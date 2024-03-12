package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dao.EmpRep;
import com.example.employee.dao.PhoneNumberRep;
import com.example.employee.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {

	@Autowired
	EmpRep	 empDao;
	
	@Autowired
	PhoneNumberRep phnumDao;
	
//	@Value("#{${portList}}")
//	Map<String,String> portNumber;
	
	
	@RequestMapping("/hello")
	public String sayHello() {
		log.info("Calling hello method");
		return "Hi this is first spring boot running on port number ";
	}
	

	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmp(@RequestBody @Validated Employee emp){
		
		
		return ResponseEntity.status(HttpStatus.CREATED)
		        .body(empDao.save(emp));
		
	}
	
	
	@GetMapping("/getAllEmp")
	public ResponseEntity<List<Employee>> getAllEmp(){
		return ResponseEntity.status(HttpStatus.OK)
		        .body(empDao.findAll());
		
	}
//	
//	//if we want to have hatoes
//	@GetMapping("/getEmpById/{id}")
//	@ResponseStatus(code = HttpStatus.OK)
//	public EntityModel<Employee> getEmpById(@PathVariable("id") int id){
//		Employee emp1= empSer.getEmpById(id);	
//		EntityModel<Employee> entityModel = EntityModel.of(emp1);
//		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllEmp());	
//		WebMvcLinkBuilder link2 = linkTo(methodOn(this.getClass()).getEmpByName(emp1.getName()));	
//		entityModel.add(link.withRel("all-users"));
//		entityModel.add(link2.withRel("getEmpByName"));
//		
//		return entityModel;
//		
//	}
//	
//	
//	@GetMapping("/getEmpByName/{name}")
//	public ResponseEntity<Employee> getEmpByName(@PathVariable("name") String name){
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body(empSer.getEmpByName(name));
//		
//	}
//	
//	
//
//	@PutMapping("/updateEmp/{id}")
//	public ResponseEntity<Employee> updateEmp(@PathVariable("id") int id,@RequestBody Employee emp){
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body(empSer.updateEmp(id,emp));
//		
//	}
//	
//	
//	@DeleteMapping("/deleteEmp/{id}")
//	public ResponseEntity<String> deleteEmp(@PathVariable("id") int id){
//		return ResponseEntity.status(HttpStatus.NO_CONTENT)
//		        .body(empSer.deleteEmp(id));
//		
//	}
//	
//// Relationships
//	
//	@GetMapping("/getVehicleByEmpId/{empId}")
//	public ResponseEntity<List<Vehicle>> getVehicleByEmpId(@PathVariable("empId") int empId){
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body(empSer.getVehicleByEmpId(empId));
//		
//	}
//	
//	
//
//	@GetMapping("/getEmpVehicleById/{empId}")
//	public ResponseEntity<Employee> getEmpVehicleById(@PathVariable("empId") int empId){
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body(empSer.getEmpVehicleById(empId));
//		
//	}
//	
//	
//	@PostMapping("/saveVehicle")
//	public ResponseEntity<Vehicle> saveVehicle(@RequestBody @Validated Vehicle veh){
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body(empSer.saveVehicle(veh));
//		
//	}
//	
//	
//	@DeleteMapping("/delAllVehicle")
//	public ResponseEntity<String> delAllVehicle(){
//		return ResponseEntity.status(HttpStatus.OK)
//		        .body(empSer.delAllVehicle());
//		
//	}
}
