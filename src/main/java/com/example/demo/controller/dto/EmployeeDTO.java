package com.example.demo.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EmployeeDTO {
	private int employeeid;
	@NotEmpty
	private String name;
	@NotEmpty
	private String contact;
}
