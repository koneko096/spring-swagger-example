package id.koneko096.swagger.api;

import id.koneko096.swagger.data.model.Employee;

import id.koneko096.swagger.data.repositories.EmployeeRepository;
import id.koneko096.swagger.utils.NullAwareBeanUtilsBean;
import io.swagger.annotations.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-17T21:35:10.731+07:00")

@Controller
public class EmployeeApiController implements EmployeeApi {

    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Optional<Employee> newEmployee = Optional.ofNullable(employeeRepository.save(employee));
        if (newEmployee.isPresent())
            return new ResponseEntity<Employee>(newEmployee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Void> deleteEmployee(Long employeeId) {
        Optional<Employee> oldEmployee = Optional.ofNullable(employeeRepository.findOne(employeeId));
        if (!oldEmployee.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        try {
            employeeRepository.delete(employeeId);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Employee> getEmployeeDetails(@ApiParam(value = "ID of Employee to return",required=true ) @PathVariable("employeeId") Long employeeId) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findOne(employeeId));
        if (employee.isPresent())
            return new ResponseEntity<Employee>(employee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Employee> updateEmployee(@ApiParam(value = "ID of Employee to update",required=true ) @PathVariable("employeeId") Long employeeId, @RequestBody Employee employee) {
        Optional<Employee> oldEmployee = Optional.ofNullable(employeeRepository.findOne(employeeId));
        if (!oldEmployee.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        NullAwareBeanUtilsBean.copyNonNullProperties(employee, oldEmployee.get());
        Optional<Employee> newEmployee = Optional.ofNullable(employeeRepository.save(oldEmployee.get()));
        if (newEmployee.isPresent())
            return new ResponseEntity<Employee>(newEmployee.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
