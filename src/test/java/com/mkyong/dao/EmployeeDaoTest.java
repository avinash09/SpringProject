package com.mkyong.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mkyong.persistence.Dao.EmployeeDao;

public class EmployeeDaoTest {

	@Test
	public void test() {
		assertNotNull(new EmployeeDao().getEmployeeAll());
	}

}
