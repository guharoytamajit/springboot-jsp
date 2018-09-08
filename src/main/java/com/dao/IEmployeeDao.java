package com.dao;

import java.util.List;

import com.entity.Employee;

public interface IEmployeeDao {
	
	public void save(Employee employee);
	public void merge(Employee employee);
    public Employee findById(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);
    
    
}
