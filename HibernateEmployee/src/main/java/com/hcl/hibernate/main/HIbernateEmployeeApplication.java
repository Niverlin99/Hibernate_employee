package com.hcl.hibernate.main;

import com.hcl.hibernate.dao.EmployeeDaoImpl;

public class HIbernateEmployeeApplication {

	public static void main(String[] args) {

		EmployeeDaoImpl daoImpl = new EmployeeDaoImpl();

		daoImpl.addEmployee();
		daoImpl.getAllEmployee();
	}

}
