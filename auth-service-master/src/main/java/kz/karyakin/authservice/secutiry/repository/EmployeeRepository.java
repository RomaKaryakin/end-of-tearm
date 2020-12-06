package kz.karyakin.authservice.secutiry.repository;

import kz.karyakin.authservice.secutiry.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
