package com.example.talent.Service.impl;

import com.example.talent.Dto.EmployeeDto;
import com.example.talent.Dto.LoginDto;
import com.example.talent.Entity.Employee;
import com.example.talent.Repo.EmployeeRepo;
import com.example.talent.Response.LoginResponse;
import com.example.talent.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getEmployee_id(),
                employeeDto.getName(),
                employeeDto.getEmail(),
                this.passwordEncoder.encode(employeeDto.getPassword())
        );
        employeeRepo.save(employee);
        return  employee.getName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDto.getEmail());
        if (employee1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
