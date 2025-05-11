package dev.srivatsan.employee_v2.controller;

import dev.srivatsan.employee_v2.dto.EmployeeDTO;
import dev.srivatsan.employee_v2.model.Employee;
import dev.srivatsan.employee_v2.service.EmployeeService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeById);
    }

    /*@GetMapping("/employee/all")
    public ResponseEntity<Page<Employee>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Employee> employees = employeeService.getAllEmployees(pageable);
        return ResponseEntity.ok(employees);
    }*/

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees(pageable);
        return ResponseEntity.ok(allEmployees);
    }

}
