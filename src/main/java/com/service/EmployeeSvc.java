package com.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IEmployeeDao;
import com.entity.Employee;
@Service
public class EmployeeSvc implements IEmployeeSvc {
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}
	@Override
	public void update(Employee employee) {
		employeeDao.merge(employee);
		
	}
	@Override
	public Employee findById(Integer id) {
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public void delete(Integer id) {
		employeeDao.delete(id);
	}

}
