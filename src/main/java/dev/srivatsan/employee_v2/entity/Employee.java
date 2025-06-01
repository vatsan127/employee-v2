package dev.srivatsan.employee_v2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "id_employee_seq", allocationSize = 1)
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private LocalDate hireDate;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "employee_id")
    private DepartmentEmployee departmentEmployee;



}
