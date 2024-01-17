package com.example.talent.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="talent")
public class Employee {


    @Id
    @Column(name="employee_id", length=20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int employee_id;

    @Column(name="Name", length = 30)
    private String Name;

    @Column(name="email", length = 50)
    private String email;

    @Column(name="password", length = 100)
    private String password;


    public Employee(int employee_id, String name, String email, String password) {
        this.employee_id = employee_id;
        Name = name;
        this.email = email;
        this.password = password;
    }

    public Employee() {
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
        return "Employee{" +
                "employee_id=" + employee_id +
                ", Name='" + Name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
