package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constomExceptions.IdNotFound;
import com.example.demo.controller.dto.EmployeeDTO;
import com.example.demo.controller.entity.EmployeeEntityClass;
import com.example.demo.service.ServieceInterface;

import jakarta.validation.Valid;

@RestController
public class ControllerClass {
	@Autowired
	private ServieceInterface serviece;

	// GETTING EMPLOYEE DETAILS BY ID
	@GetMapping("/getbyId")
	public EmployeeEntityClass getbyId(@RequestParam int Id) {
		return serviece.getbyId(Id);
	}

// POSTING EMPLOYEE DETAILS TO DB
	@PostMapping("/postvalue")
	public EmployeeDTO postvalue(@Valid @RequestBody EmployeeDTO emp) {
		return serviece.postvalue(emp);
	}

// GETTING ALL EMPLOYEES IN DB
	@GetMapping("/getall")
	public List<EmployeeEntityClass> getallemployee() {
		return serviece.getallemployee();
	}

//DELECTING EMPLOYEE DETAILS BY ID 
	@DeleteMapping("/deletebyid")
	public void deletebyId(@RequestParam int Id) {
		serviece.deletebyid(Id);
	}

//UPDATING EMPLOYEE DETAILS BY ID 
	@PutMapping("/updataevalue")
	public EmployeeEntityClass updatevalue(@RequestBody EmployeeDTO dto) throws IdNotFound {
		return serviece.updatevalue(dto);
	}
}
