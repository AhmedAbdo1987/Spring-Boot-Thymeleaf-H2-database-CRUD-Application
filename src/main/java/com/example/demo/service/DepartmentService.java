package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService { 
	@Autowired
	DepartmentRepository repository;
	public List<Department> findallDepartment(){
		return (List<Department>) repository.findAll();
			
	}
	public Department findDepartmentById(int id) {
		Optional<Department> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Department();
	}
	public Department addDepatment(Department department) {
		return repository.save(department);
	}
	public Department updateDepartment(Department department) {
		Optional<Department> result = repository.findById(department.getId());
		Department existing = result.get();
		existing.setName(department.getName());
		existing.setNoofStubent(department.getNoofStubent());
		return repository.save(existing);
		
	}
	public void deletById(int id) {
		repository.deleteById(id); 
	}
	
	

}
