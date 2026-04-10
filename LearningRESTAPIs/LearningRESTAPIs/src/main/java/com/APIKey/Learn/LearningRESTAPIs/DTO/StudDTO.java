package com.APIKey.Learn.LearningRESTAPIs.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudDTO {
    private Long  id;
    private String name;
    private String email;
}
