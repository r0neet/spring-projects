package net.javaguides.employ_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employ_backend.DTO.EmployDTO;
import net.javaguides.employ_backend.Mapper.Employmapper;
import net.javaguides.employ_backend.entity.Employee;
import net.javaguides.employ_backend.exception.ResourceNotFoundException;
import net.javaguides.employ_backend.repository.employrepo;
import net.javaguides.employ_backend.service.EmployService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployService {
    private employrepo employrepository;
    // Constructor injection

    @Override
    public EmployDTO createEmployee(EmployDTO employDTO) {
        Employee employee = Employmapper.maptoEmployee(employDTO);
        Employee savedEmployee = employrepository.save(employee);
        return Employmapper.maptoDTO(savedEmployee);
    }

    @Override
    public EmployDTO getEmployeebyID(Long employeeId) {
        Employee employee = employrepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        return Employmapper.maptoDTO(employee);
    }

    @Override
    public List<EmployDTO> getAllEmployees() {
        List<Employee> employees = employrepository.findAll();
        return employees.stream().map((employee) -> Employmapper.maptoDTO(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployDTO updateEmployee(Long employeeId, EmployDTO employDTO) {
        Employee Employee = employrepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        Employee.setFirstName(employDTO.getFirstName());
        Employee.setLastName(employDTO.getLastName());
        Employee.setEmail(employDTO.getEmail());

        Employee updatedEmployeeObj = employrepository.save(Employee);
        return Employmapper.maptoDTO(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employrepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + employeeId));
        employrepository.delete(employee);
    }
}
