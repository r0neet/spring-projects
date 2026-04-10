package net.javaguides.employ_backend.repository;

import net.javaguides.employ_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employrepo extends JpaRepository<Employee, Long> {
}
