package com.endurance.india.models;

public class Employee
{

    private Integer id;

    private String name;
    private String department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public Employee(Integer id, String name, String department)
    {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDepartment()
    {
        return department;
    }
}