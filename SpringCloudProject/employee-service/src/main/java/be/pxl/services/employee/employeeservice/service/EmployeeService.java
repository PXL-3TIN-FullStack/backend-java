package be.pxl.services.employee.employeeservice.service;

import be.pxl.services.employee.employeeservice.dto.EmployeeRequest;
import be.pxl.services.employee.employeeservice.dto.EmployeeResponse;
import be.pxl.services.employee.employeeservice.model.Employee;
import be.pxl.services.employee.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public void addEmployee(EmployeeRequest employeeRequest) {

        Employee employee = Employee.builder()
                .age(employeeRequest.getAge())
                .name(employeeRequest.getName())
                .position(employeeRequest.getPosition())
                .build();

        employeeRepository.save(employee);
    }

    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(employee -> mapToEmployeeResponse(employee)).toList();
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .age(employee.getAge())
                .name(employee.getName())
                .position(employee.getPosition())
                .build();
    }
}
