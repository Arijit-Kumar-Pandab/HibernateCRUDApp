package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Employee;
import util.JdbcUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public boolean addEmployee(String name, String dept, int salary) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String insertQuery = null;
		try {
//			connection = JdbcUtil.getConnection();
			if (connection != null) {
				insertQuery = "Insert into employees(empDept, salary, Name) values(?, ?, ?)";
				pstmt = connection.prepareStatement(insertQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, dept);
				pstmt.setInt(2, salary);
				pstmt.setString(3, name);
			}
			int rowAffected = -1;
			if (pstmt != null) {
				rowAffected = pstmt.executeUpdate();
				if (rowAffected >= 1)
					return true;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String deleteQuery = null;

		try {
//			connection = JdbcUtil.getConnection();
			if (connection != null) {
				deleteQuery = "Delete from employees where empId = ?";
				pstmt = connection.prepareStatement(deleteQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, id);
			}

			int rowAffected = -1;
			if (pstmt != null) {
				rowAffected = pstmt.executeUpdate();
			}

			if (rowAffected >= 1) {
				return true;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee searchEmployee(int id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String searchQuery = null;
		Employee employee = null;

		try {
//			connection = JdbcUtil.getConnection();
			if (connection != null) {
				searchQuery = "Select * from employees where empId = ?";
				pstmt = connection.prepareStatement(searchQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, id);
			}
			if (pstmt != null) {
				resultSet = pstmt.executeQuery();
			}
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt(1));
				employee.setDept(resultSet.getString(2));
				employee.setName(resultSet.getString(4));
				employee.setSalary(resultSet.getInt(3));
			}
			if (employee != null) {
				return employee;
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEmployeeDetails(int id, String name, String dept, int salary) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		String updateQuery = null;

		try {
//			connection = JdbcUtil.getConnection();

			if (connection != null) {
				updateQuery = "Update employees set Name = ?, empDept = ?, salary = ? where empId = ?";
				pstmt = connection.prepareStatement(updateQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, name);
				pstmt.setString(2, dept);
				pstmt.setInt(3, salary);
				pstmt.setInt(4, id);
			}
			
			int rowAffected = -1;
			if (pstmt != null) {
				rowAffected = pstmt.executeUpdate();
			}
			
			if (rowAffected >= 1) {
				return true;
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
