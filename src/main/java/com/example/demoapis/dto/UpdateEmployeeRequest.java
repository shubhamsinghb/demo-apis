package com.example.demoapis.dto;

import com.example.demoapis.models.Address;
import com.example.demoapis.models.Department;
import com.example.demoapis.models.Employee;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UpdateEmployeeRequest {

    @NotBlank
    private String name;

    @Min(18)
    @Max(60)
    private int age;

    @NonNull
    private Department department;
    private Address address;

    public Employee to(String id){

        return Employee.builder().name(this.name).age(this.age).
                address(this.address).department(this.department)
                .updatedOn(System.currentTimeMillis()).id(id).build();
    }
}
