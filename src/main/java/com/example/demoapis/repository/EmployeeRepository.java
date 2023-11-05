package com.example.demoapis.repository;

import com.example.demoapis.dto.UpdateEmployeeRequest;
import com.example.demoapis.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private HashMap<String, Employee> employeeHashMap= new HashMap<>();

    public Employee create(Employee employee){
        employeeHashMap.put(employee.getId(), employee);
        return employee;

    }

    public Employee get(String id){
        return employeeHashMap.getOrDefault(id,null);
    }

    public List<Employee> get(){
        return employeeHashMap.
                values().
                stream().
                collect(Collectors.toList());
    }


    public Employee update(Employee employee) {
        if(employeeHashMap.containsKey(employee.getId())){
            merge(employeeHashMap.get(employee.getId()), employee);
            employeeHashMap.put(employee.getId(),employee);

        }

        return employee;
    }

    private void merge(Employee oldEntry, Employee newEntry){
        newEntry.setCreatedOn(oldEntry.getCreatedOn());
    }

    public Employee delete(String id){
        return employeeHashMap.remove(id);
    }
}
