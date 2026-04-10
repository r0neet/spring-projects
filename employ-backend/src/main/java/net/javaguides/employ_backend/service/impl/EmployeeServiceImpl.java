package net.javaguides.employ_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.employ_backend.DTO.EmployDTO;
import net.javaguides.employ_backend.Mapper.Employmapper;
import net.javaguides.employ_backend.entity.Employee;
import net.javaguides.employ_backend.repository.employrepo;
import net.javaguides.employ_backend.service.EmployService;
import org.springframework.stereotype.Service;

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


    
}