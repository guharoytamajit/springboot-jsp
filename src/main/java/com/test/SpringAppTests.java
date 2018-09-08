package com.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Employee;
import com.service.IEmployeeSvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class SpringAppTests {
@Autowired
IEmployeeSvc employeeSvc;
@Test
public void testSayHello() {
	
	employeeSvc.save(new Employee(1,"tamajit"));
Assert.assertEquals("tamajit",employeeSvc.findById(1).getEname());
	Assert.assertEquals("tamajit","tamajit");
}
}