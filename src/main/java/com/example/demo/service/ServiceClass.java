package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.constomExceptions.IdNotFound;
import com.example.demo.controller.dto.EmployeeDTO;
import com.example.demo.controller.entity.EmployeeEntityClass;
import com.example.demo.repository.RepositoryInterface;

@Service
public class ServiceClass implements ServieceInterface {
	@Autowired
	private RepositoryInterface repo;
	@Autowired
	private ModelMapper modelmapper;

	// GETTING EMPLOYEE DETAILS BY ID METHOD
	public EmployeeEntityClass getbyId(int id) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntityClass> obl = repo.findById(id);
		return obl.isPresent() ? obl.get() : null;
	}

	// POSTING EMPLOYEE DETAILS TO DB METHOD
	public EmployeeDTO postvalue(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		Optional<EmployeeEntityClass> obj = repo.findById(emp.getEmployeeid());
		EmployeeEntityClass empEntity;
		if (obj.isPresent()) {
			empEntity = obj.get();
		} else {
			empEntity = new EmployeeEntityClass();
		}
		empEntity.setContact(emp.getContact());
		empEntity.setName(emp.getName());

		EmployeeEntityClass empReturnd = repo.save(empEntity);

		System.err.println("empReturnd:" + empReturnd.getEmployeeid());
		EmployeeDTO empDTO = modelmapper.map(empReturnd, EmployeeDTO.class);
		return empDTO;
	}

	// GETTING ALL EMPLOYEES IN DB METHOD
	public List<EmployeeEntityClass> getallemployee() {
		return (List<EmployeeEntityClass>) repo.findAll();
	}

	// DELECTING EMPLOYEE DETAILS BY ID METHOD
	@Override
	public void deletebyid(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	// UPDATING EMPLOYEE DETAILS BY ID METHOD
	@Override
	public EmployeeEntityClass updatevalue(EmployeeDTO dto) throws IdNotFound {
		// TODO Auto-generated method stub
		Optional<EmployeeEntityClass> obj = repo.findById(dto.getEmployeeid());
		if (!obj.isPresent()) {
			throw new IdNotFound("Id not found ");
		}
		EmployeeEntityClass emp = obj.get();
		emp.setContact(dto.getContact());
		emp.setName(dto.getName());
		return repo.save(emp);
	}

}
