package dev.srivatsan.employee_v2.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "department_employee")
public class DepartmentEmployee {
    @Id
    private long employeeId;
    private String departmentId;
    private Timestamp fromDate;
    private Timestamp toDate;

/*    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;*/

}

