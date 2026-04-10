package com.APIKey.Learn.LearningRESTAPIs.service;

import com.APIKey.Learn.LearningRESTAPIs.DTO.AddstudReqDTO;
import com.APIKey.Learn.LearningRESTAPIs.DTO.StudDTO;

import java.util.List;
import java.util.Map;

public interface StudService {

    List<StudDTO> getAllStudent();

    StudDTO getStudentbyId(long id);

    StudDTO createnewstudent(AddstudReqDTO addstudReqDTO);

    void deleteAstudentById(long id);

    StudDTO updatestudent(long id, AddstudReqDTO addstudReqDTO);

    StudDTO updatePartialstudent(long id, Map<String, Object> update);
}
// the interface was made instead of direct implementation bcoz later code can be extended - agar future mea koe aur type ka implementation chaiye tho