package dev.srivatsan.employee_v2.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class DepartmentEmployee_CK implements Serializable {
    private long employeeId;
    private int departmentId;

}
