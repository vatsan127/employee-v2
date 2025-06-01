package dev.srivatsan.employee_v2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class Department {
    @Id
    private int id;
    private String deptName;
}
