/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package id.koneko096.swagger.api;

import id.koneko096.swagger.data.model.Employee;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-17T23:23:25.554+07:00")

@Api(value = "employee", description = "the employee API")
public interface EmployeeApi {

    @ApiOperation(value = "Create employee", notes = "Creates a new Employee", response = Employee.class, tags={ "employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Employee.class),
        @ApiResponse(code = 400, message = "Invalid input", response = Void.class) })
    
    @RequestMapping(value = "/employee",
        produces = { "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    ResponseEntity<Employee> createEmployee(@RequestBody Employee employee);


    @ApiOperation(value = "Delete employee by ID", notes = "Deletes a single Employee", response = Void.class, tags={ "employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class),
        @ApiResponse(code = 400, message = "Invalid Employee ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Employee not found", response = Void.class) })
    
    @RequestMapping(value = "/employee/{employeeId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteEmployee(@ApiParam(value = "ID of Employee to delete",required=true ) @PathVariable("employeeId") Long employeeId);


    @ApiOperation(value = "List employees", notes = "Returns list of Employee", response = Employee.class, responseContainer = "List", tags={ "employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Employee.class, responseContainer = "List") })
    
    @RequestMapping(value = "/employee",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Employee>> getAllEmployees();


    @ApiOperation(value = "Find employee by ID", notes = "Returns a single Employee", response = Employee.class, tags={ "employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Employee.class),
        @ApiResponse(code = 400, message = "Invalid Employee ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Employee not found", response = Void.class) })
    
    @RequestMapping(value = "/employee/{employeeId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployeeDetails(@ApiParam(value = "ID of Employee to return",required=true ) @PathVariable("employeeId") Long employeeId);


    @ApiOperation(value = "Update employee", notes = "Updates an existing Employee", response = Employee.class, tags={ "employee", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Employee.class),
        @ApiResponse(code = 400, message = "Invalid input", response = Void.class),
        @ApiResponse(code = 404, message = "Employee not found", response = Void.class) })
    
    @RequestMapping(value = "/employee/{employeeId}",
        produces = { "application/json" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.PUT)
    ResponseEntity<Employee> updateEmployee(@ApiParam(value = "ID of Employee to update",required=true ) @PathVariable("employeeId") Long employeeId, @RequestBody Employee employee);

}