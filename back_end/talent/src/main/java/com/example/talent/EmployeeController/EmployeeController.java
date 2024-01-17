package com.example.talent.EmployeeController;


import com.example.talent.Dto.EmployeeDto;
import com.example.talent.Dto.LoginDto;
import com.example.talent.Response.LoginResponse;
import com.example.talent.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(path="/save")
    public String saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        String id=employeeService.addEmployee(employeeDto);
        return id;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto)
    {
        LoginResponse loginResponse= employeeService.loginEmployee(loginDto);
        return  ResponseEntity.ok(loginResponse);
    }
}
