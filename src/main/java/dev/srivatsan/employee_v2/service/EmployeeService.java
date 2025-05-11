package dev.srivatsan.employee_v2.service;

import dev.srivatsan.employee_v2.dto.EmployeeDTO;
import dev.srivatsan.employee_v2.exception.CustomException;
import dev.srivatsan.employee_v2.exception.UserNotFoundException;
import dev.srivatsan.employee_v2.model.Employee;
import dev.srivatsan.employee_v2.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Long id) {
        Optional<Employee> result = employeeRepository.findById(id);
        return result.orElseThrow(UserNotFoundException::new);
    }

    /*public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }*/

    public List<EmployeeDTO> getAllEmployees(Pageable pageable) {
        Page<Object[]> employeeByPage = employeeRepository.findAllByPage(pageable);
        List<Object[]> employeeFullDetails = employeeByPage.getContent();

        return employeeFullDetails.stream()
                .map(e -> new EmployeeDTO(
                                String.valueOf(e[0]), String.valueOf(e[1]), String.valueOf(e[2])
                        )
                )
                .toList();
    }

}
