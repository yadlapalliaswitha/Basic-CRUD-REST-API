package com.example.emsapi.mapper;

import com.example.emsapi.dto.EmployeeDto;
import com.example.emsapi.entity.Employee;

public class Mapper {

    public static Employee maptoEmployee(EmployeeDto employeeDto){

        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                employeeDto.getDepartment(),
                employeeDto.getSalary()
        );
        return  employee;
    }

    public static EmployeeDto maptoEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
        return employeeDto;
    }
}
