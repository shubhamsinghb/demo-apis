package com.example.demoapis.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder        //This annotation helps in using builder pattern for employee
public class Employee {

    private String id;
    private String name;
    private int age;
    private Department department;

    private Address address;

    private Long createdOn;
    private Long updatedOn;

}
