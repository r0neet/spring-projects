package net.javaguides.employ_backend.service;

import net.javaguides.employ_backend.DTO.EmployDTO;

import java.util.List;

public interface EmployService {
    EmployDTO createEmployee(EmployDTO employDTO);
    
    EmployDTO getEmployeebyID(Long employeeId);

    List<EmployDTO> getAllEmployees();

    EmployDTO updateEmployee(Long employeeId, EmployDTO employDTO);

    void deleteEmployee(Long employeeId);
}
