package com.example.demoapis.controller;

import com.example.demoapis.dto.CreateEmployeeRequest;
import com.example.demoapis.dto.UpdateEmployeeRequest;
import com.example.demoapis.models.Employee;
import com.example.demoapis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) {

        return employeeService.create(createEmployeeRequest);
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") String id) {
        return employeeService.get(id);
    }

    @GetMapping("/employee/all")
    public List<Employee> getAllEmployee(){
        return employeeService.get();
    }

    @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId")String id,
                                   @RequestBody UpdateEmployeeRequest updateEmployeeRequest){

        return employeeService.update(id, updateEmployeeRequest);
    }

    @DeleteMapping("/employee")
    public Employee deleteEmployee(@RequestParam("id") String employeeId){
        return employeeService.delete(employeeId);
    }
}