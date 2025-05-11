package dev.srivatsan.employee_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String gender;

}
