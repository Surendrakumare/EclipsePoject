package com.example.demo.service;

import java.util.List;

import com.example.demo.constomExceptions.IdNotFound;
import com.example.demo.controller.dto.EmployeeDTO;
import com.example.demo.controller.entity.EmployeeEntityClass;

public interface ServieceInterface {
	// GETTING EMPLOYEE DETAILS BY ID METHOD
	public EmployeeEntityClass getbyId(int id);

	// POSTING EMPLOYEE DETAILS TO DB METHOD
	public EmployeeDTO postvalue(EmployeeDTO emp);

	// GETTING ALL EMPLOYEES IN DB METHOD
	public List<EmployeeEntityClass> getallemployee();

	// DELECTING EMPLOYEE DETAILS BY ID METHOD
	public void deletebyid(int id);

	// UPDATING EMPLOYEE DETAILS BY ID METHOD
	public EmployeeEntityClass updatevalue(EmployeeDTO dto) throws IdNotFound;

}
