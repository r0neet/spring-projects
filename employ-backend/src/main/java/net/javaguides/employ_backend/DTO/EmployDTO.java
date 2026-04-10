package net.javaguides.employ_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    // Constructors, getters, and setters
}
