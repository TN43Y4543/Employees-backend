package employee.management.backend.controller;

import employee.management.backend.dto.EmployeeDto;
import employee.management.backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //build add employee Rest api;
        @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //build getemployee rest api
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")long empid)
    {
        EmployeeDto employeeDto=employeeService.getEmployee(empid);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    //build get all employees
    @GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    //build update employee Rest api
    @PutMapping("/{id}")
    public  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id")Long employeeId,@RequestBody EmployeeDto updateEmployee)
    {
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updateEmployee);
        return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }

    //build delete employee rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee Deleted Successfully!",HttpStatus.OK);
    }


}
