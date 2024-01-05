package serviceFactory;

import service.EmployeeServiceImpl;
import service.IEmployeeService;

public class EmployeeServiceFactory {
	private EmployeeServiceFactory() {

	}

	private static IEmployeeService employeeService;

	public static IEmployeeService getEmployeeService() {
		if (employeeService == null) {
			employeeService = new EmployeeServiceImpl();
		}
		return employeeService;
	}
}
