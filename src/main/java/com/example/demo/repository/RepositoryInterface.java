package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.controller.entity.EmployeeEntityClass;

public interface RepositoryInterface extends CrudRepository<EmployeeEntityClass, Integer> {

	Optional<List<EmployeeEntityClass>> findByIdAndNameIgnoreCase(int id, String name);

	@Query("select * from employeetable where id=:id and name=:name")
	List<EmployeeEntityClass> getByIdAndNameIgnoreCase(int id, String name);
}
