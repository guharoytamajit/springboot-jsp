package com.validator;

import java.util.Calendar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.entity.Employee;
@Component
public class CustomEmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		 return Employee.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Employee employee = (Employee) target;
		 Calendar dobDate = Calendar.getInstance();
		 if(employee.getDob()!=null)
		 dobDate.setTime(employee.getDob());
		  Calendar today = Calendar.getInstance();
		 if ((today.get(Calendar.YEAR)-dobDate.get(Calendar.YEAR)<18)) {
		 errors.rejectValue("dob",null, "emloyee not adult ");
		 }
	}

}
