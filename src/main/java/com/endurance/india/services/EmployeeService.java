package com.endurance.india.services;

import com.endurance.india.models.Employee;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@PropertySource(value = {"classpath:settings.properties"})
public class EmployeeService
{
    public Employee getEmployee() {
        return new Employee(1, "Mudit Goyal", "Engineering");
    }

    public ArrayList<Employee> getListOfEmployees()
    {
        ArrayList<Employee> employeeList =  new ArrayList<Employee>();
        employeeList.add(new Employee(1, "Mudit Goyal", "Engineering"));
        employeeList.add(new Employee(2, "Ashish Singh", "Operations"));
        employeeList.add(new Employee(3, "Vijay Bhatia", "IT Ops"));

        return employeeList;
    }

}