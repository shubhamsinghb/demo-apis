package com.example.demoapis.dto;

import com.example.demoapis.models.Address;
import com.example.demoapis.models.Department;
import com.example.demoapis.models.Employee;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;
//this is employee DTO (Data transfer object)
@Getter
@Setter
@ToString
public class CreateEmployeeRequest {

    @NotBlank
    private String name;

    @Min(18)
    @Max(60)
    private int age;

    @NonNull
    private Department department;

    private Address address;

    public Employee to(){

        Employee.EmployeeBuilder employeeBuilder =Employee.builder();
        Employee employee = employeeBuilder.name(this.name)
                        .age(this.age).address(this.address).department(this.department)
                        .createdOn(System.currentTimeMillis()).updatedOn(System.currentTimeMillis())
                        .id(UUID.randomUUID().toString()).build();


//        Employee employee = new Employee();
//        employee.setName(this.name);
//        employee.setAge(this.age);
//        employee.setAddress(this.address);
//        employee.setDepartment(this.department);
//
//        employee.setCreatedOn(System.currentTimeMillis());
//        employee.setUpdatedOn(System.currentTimeMillis());
//        employee.setId(UUID.randomUUID().toString());

        return employee;
    }

}
