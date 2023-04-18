package wf.rh.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import wf.rh.domain.Employee;

/**
 * Spring Data JPA repository for the Employee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
