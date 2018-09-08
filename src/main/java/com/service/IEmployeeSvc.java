package com.service;

import java.util.List;

import com.entity.Employee;

public interface IEmployeeSvc {
	public void save(Employee employee);
	public void update(Employee employee);
    public Employee findById(Integer id);
    public List<Employee> findAll();
    public void delete(Integer id);
}
