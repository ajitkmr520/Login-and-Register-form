package com.example.talent.Dto;

public class EmployeeDto {

    private  int employee_id;
    private  String Name;
    private  String email;
    private  String password;

    public EmployeeDto(int employee_id, String name, String email, String password) {
        this.employee_id = employee_id;
        Name = name;
        this.email = email;
        this.password = password;
    }

    public EmployeeDto() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employee_id=" + employee_id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
