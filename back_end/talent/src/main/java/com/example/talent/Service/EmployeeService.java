package com.example.talent.Service;

import com.example.talent.Dto.EmployeeDto;
import com.example.talent.Dto.LoginDto;
import com.example.talent.Response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDto employeeDto);


    LoginResponse loginEmployee(LoginDto loginDto);
}
