package com.example.emsapi.service.impl;

import com.example.emsapi.dto.EmployeeDto;
import com.example.emsapi.entity.Employee;
import com.example.emsapi.mapper.Mapper;
import com.example.emsapi.repository.EmployeeRepository;
import com.example.emsapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = Mapper.maptoEmployee(employeeDto);
       Employee savedEmployee = employeeRepository.save(employee);
        return Mapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
       return Mapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) ->Mapper.maptoEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee is not exist with given id: "+id));
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setSalary(employeeDto.getSalary());
        Employee updatedEmployee = employeeRepository.save(employee);
        return Mapper.maptoEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee Id not exist "+id));
        employeeRepository.delete(employee);

    }
}
