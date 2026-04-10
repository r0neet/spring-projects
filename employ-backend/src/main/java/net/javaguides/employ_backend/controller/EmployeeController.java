package net.javaguides.employ_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.employ_backend.DTO.EmployDTO;
import net.javaguides.employ_backend.service.EmployService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
}
