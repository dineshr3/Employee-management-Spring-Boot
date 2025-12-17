package CRUD.Demo.project.service;

import CRUD.Demo.project.Dto.UpdateEmployeeDto;
import CRUD.Demo.project.Dto.EmployeeResponseDto;
import CRUD.Demo.project.Dto.CreateEmployeeDto;
import CRUD.Demo.project.entity.Employee;
import CRUD.Demo.project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


//    Create User
//    public User createUser(User user){
//        return employeeRepository.save(user);
//    }

    // Create User using DTO
    public CreateEmployeeDto createUser(CreateEmployeeDto dto){
        Employee user =new Employee();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        Employee savedUser = employeeRepository.save(user);
        dto.setId(user.getId());
        return dto;
    }



//    Return Particular User
//    public User getUserById(Long id)
//    {
//        return employeeRepository.getById(id);
//    }

    // DTO Return
    public EmployeeResponseDto getUserById(Long id){
        Employee user = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("No User found"));
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(user.getId());
        dto.setName((user.getName()));
        dto.setEmail(user.getEmail());
        return dto;
    }

    // Update particular detail
//    public User updateUserById(Long id, User user){
//        return employeeRepository.findById(id).map(u->{
//            if (user.getEmail()!=null){
//                u.setEmail(user.getEmail());
//            }
//            if (user.getName()!=null) {
//                u.setName(user.getName());
//            }
//            if (user.getPassword()!=null){
//                u.setPassword(user.getPassword());
//            }
//            return employeeRepository.save(u);
//        }).orElseThrow(()-> new RuntimeException("User Not Found"));
//
//    }

    // Dto Update Patch
    public EmployeeResponseDto updateUserById(Long id, UpdateEmployeeDto dto){
        Employee user = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("No User found"));
        if (dto.getName()!=null){
        user.setName(dto.getName());}

        if (dto.getEmail()!=null){
            user.setEmail(dto.getEmail());
        }

        if (dto.getPassword()!=null && !dto.getPassword().equals(user.getPassword())){
            user.setPassword(dto.getPassword());
        }
        Employee savedUser= employeeRepository.save(user);
        EmployeeResponseDto response = new EmployeeResponseDto();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setEmail(savedUser.getEmail());

        return response;
    }


    // Delete
    public void deleteUserById(Long id){
        employeeRepository.deleteById(id);
    }

    // Return All User
    public List<Employee> getAllUser(){
        return employeeRepository.findAll();
    }

    // Replace the User details
    public Employee replaceUserById(Long id, Employee user){
        return employeeRepository.findById(id).map((exist)->{
            user.setId(exist.getId());
            return employeeRepository.save(user);
        }).orElseThrow(()-> new RuntimeException("User Not found"));
    }
}
