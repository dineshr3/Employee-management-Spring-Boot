package CRUD.Demo.project.Controller;


import CRUD.Demo.project.Dto.UpdateEmployeeDto;
import CRUD.Demo.project.Dto.EmployeeResponseDto;
import CRUD.Demo.project.Dto.CreateEmployeeDto;
import CRUD.Demo.project.entity.Employee;
import CRUD.Demo.project.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService =employeeService;
    }

    // Create
    @PostMapping
    public CreateEmployeeDto creatUser(@RequestBody CreateEmployeeDto dto){
        return employeeService.createUser(dto);
    }

    //Return Particular User
    @GetMapping("/{id}")
    public EmployeeResponseDto getUserById(@PathVariable Long id){
        return employeeService.getUserById(id);
    }

    // Update Particular data from User
    @PatchMapping("/{id}")
    public EmployeeResponseDto updateUserByID(@PathVariable Long id, @RequestBody UpdateEmployeeDto dto){
        return employeeService.updateUserById(id,dto);
    }

    // Update
    @PutMapping("/{id}")
    public Employee replaceUserByid(@PathVariable Long id, @RequestBody Employee user){
        return employeeService.replaceUserById(id, user);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        employeeService.deleteUserById(id);
    }

    // Return All User
    @GetMapping
    public List<Employee> getAllUser(){
        return employeeService.getAllUser();
    }
}
