package dev.srivatsan.employee_v2.repository;


import dev.srivatsan.employee_v2.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "select first_name, last_name, gender from employee;", nativeQuery = true)
    Page<Object[]> findAllByPage(Pageable pageable);

}
