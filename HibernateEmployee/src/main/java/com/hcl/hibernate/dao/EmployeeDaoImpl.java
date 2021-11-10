package com.hcl.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import com.hcl.hibernate.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public Configuration configuration;
	public SessionFactory sessionFactory;
	public Session session;
	public Transaction transaction;
	List<Employee> employeeList = new ArrayList<>();

	@Override
	public void addEmployee() {
		Scanner scanner = new Scanner(System.in);
		configuration = new Configuration().configure("hibernate-config/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		for (int i = 1; i <= 1; i++) {
			int id = scanner.nextInt();
			String name = scanner.next();
			String salary = scanner.next();

			Employee emp = new Employee();
			emp.setEmp_id(id);
			emp.setEmp_name(name);
			emp.setSalary(salary);
			employeeList.add(emp);

		}
		for (Employee e : employeeList) {
			session.save(e);

		}
		System.out.println("Inserted Successfully");
		transaction.commit();
		session.close();
	}

	@Override
	public void getAllEmployee() {
		configuration = new Configuration().configure("hibernate-config/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		System.out.println("All details");
		for (Employee e : employeeList) {
			session.save(e);
			System.out.println(e.getEmp_id() + "\t" + e.getEmp_name() + "\t" + e.getSalary());
		}

		transaction.commit();
		session.close();
	}

}
