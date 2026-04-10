package net.javaguides.employ_backend.service;

import net.javaguides.employ_backend.DTO.EmployDTO;
import net.javaguides.employ_backend.entity.Employee;

public interface EmployService {
    EmployDTO createEmployee(EmployDTO employDTO);

}
