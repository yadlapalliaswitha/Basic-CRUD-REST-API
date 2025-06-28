package com.example.emsapi.controller;

import com.example.emsapi.dto.EmployeeDto;
import com.example.emsapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //create a new employee using REST API
    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto){

        EmployeeDto employeeDto1 = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(employeeDto1, HttpStatus.CREATED);
    }

    // create REST API to get single employee by using id

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        EmployeeDto employeeDto = employeeService.getEmployee(id);

        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    //create a REST API to get all employees
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employeeDto = employeeService.getAllEmployees();

        return new ResponseEntity<>(employeeDto , HttpStatus.OK);
    }

    //create REST API to update existing employee
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id,
                                              @RequestBody EmployeeDto employeeDto){

        EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto1);

    }

    //create rest api to delete existing employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted sucessfully");
    }
}
