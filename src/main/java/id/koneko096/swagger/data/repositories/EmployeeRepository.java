package id.koneko096.swagger.data.repositories;

import id.koneko096.swagger.data.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long>
{
    @Override
    List<Employee> findAll();
}
