package net.javaguides.employ_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.employ_backend.DTO.EmployDTO;
import net.javaguides.employ_backend.service.EmployService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployService employService;

    //Building ADD Employee REST API
    @PostMapping
    public ResponseEntity<EmployDTO> createEmployee(@RequestBody EmployDTO employDTO){
       EmployDTO savedEmployDTO = employService.createEmployee(employDTO);
       return new ResponseEntity<>(savedEmployDTO, HttpStatus.CREATED);
    }
    
    //Building Get Employee REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployDTO employeeDTO = employService.getEmployeebyID(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

    //Building Get ALL Employess REST API
    @GetMapping
    public ResponseEntity<List<EmployDTO>> getallEmployee(){
        List<EmployDTO> employees = employService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployDTO> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployDTO updateEmployee){
        EmployDTO employDTo = employService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(employDTo);
    }

    //Building delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") Long employeeId){
        employService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
