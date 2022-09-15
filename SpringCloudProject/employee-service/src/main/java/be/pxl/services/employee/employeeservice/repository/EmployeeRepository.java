package be.pxl.services.employee.employeeservice.repository;

import be.pxl.services.employee.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
