package net.javaguides.employ_backend.Mapper;

import net.javaguides.employ_backend.DTO.EmployDTO;
import net.javaguides.employ_backend.entity.Employee;

public class Employmapper {

    public static EmployDTO maptoDTO(Employee employee) {
        return new EmployDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee maptoEmployee(EmployDTO employDTO) {
        return new Employee(
                employDTO.getId(),
                employDTO.getFirstName(),
                employDTO.getLastName(),
                employDTO.getEmail()
        );
    }
}

