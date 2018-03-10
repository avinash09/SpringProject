package com.mkyong.web.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.persistence.Dao.EmployeeDao;
import com.mkyong.web.datalayer.Employee;

@Service("testservice")
public class TestService {
	
	@Autowired
	public EmployeeDao employeedao;
	
	public void executetest(String value){
		
		System.out.println("In Service by autowiring value::"+value);
	}
	public void saveEmployee(JSONObject jsonObject) {
		Employee employee = new Employee();
		employee.setName(jsonObject.getString("name"));
		employee.setAge(jsonObject.getDouble("age"));
		employeedao.create(employee);
		
	}
	public JSONArray getEmployeeAll() {
		List list = employeedao.getEmployeeAll();
		JSONArray jsonArray = new JSONArray(list);
		return jsonArray;
	}

}
