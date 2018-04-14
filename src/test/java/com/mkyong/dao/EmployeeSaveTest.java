package com.mkyong.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.mkyong.persistence.Dao.EmployeeDao;
import com.mkyong.web.datalayer.Employee;

public class EmployeeSaveTest {

	@Test
	public void test() {
		Employee e = new Employee("avinash", 22d);
		e.setCreatedate(new Date());
		e.setModidate(new Date());
		assertNotNull(new EmployeeDao().create(e));
	}

}
