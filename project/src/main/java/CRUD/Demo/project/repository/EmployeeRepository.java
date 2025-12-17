package CRUD.Demo.project.repository;

import CRUD.Demo.project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository <Employee,Long> {
}
