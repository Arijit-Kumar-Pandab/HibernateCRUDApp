package service;

import dto.Employee;

public interface IEmployeeService {
	public boolean addEmployee(String name, String dept, int salary);

	public boolean deleteEmployee(int id);

	public Employee searchEmployee(int id);

	public boolean updateEmployeeDetails(int id, String name, String dept, int salary);
}
