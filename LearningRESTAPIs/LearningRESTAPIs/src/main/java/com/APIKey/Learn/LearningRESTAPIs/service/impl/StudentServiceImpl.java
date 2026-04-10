package com.APIKey.Learn.LearningRESTAPIs.service.impl;

import com.APIKey.Learn.LearningRESTAPIs.DTO.AddstudReqDTO;
import com.APIKey.Learn.LearningRESTAPIs.DTO.StudDTO;
import com.APIKey.Learn.LearningRESTAPIs.entity.Student;
import com.APIKey.Learn.LearningRESTAPIs.repository.StudentRepo;
import com.APIKey.Learn.LearningRESTAPIs.service.StudService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service                                // it tells ki sara ka saraa buizz logic yaha pe hoga
@RequiredArgsConstructor
public class StudentServiceImpl implements StudService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;


    @Override
    public List<StudDTO> getAllStudent() {

        List<Student> students = studentRepo.findAll();
                  // for loop could have been used to convert Student (data) to studDTO as we need the DTO to be returned  but we stream as DTO list can be modified
      //  return students.stream().map(student -> new StudDTO(student.getId(), student.getName(), student.getEmail())).toList();
        return students.stream().map(student -> modelMapper.map(student, StudDTO.class)).toList(); //used modelmapper dependency to directly convert entity(student data) to DTO instead of naming each data agian and again
    }

    @Override
    public StudDTO getStudentbyId(long id) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        return modelMapper.map(student, StudDTO.class);        //used modelmapper dependency to directly convert entity(student data) to DTO
    }

    @Override
    public StudDTO createnewstudent(AddstudReqDTO addstudReqDTO) {
        Student newStudent = modelMapper.map(addstudReqDTO, Student.class); //
        Student student = studentRepo.save(newStudent);
        return modelMapper.map(student, StudDTO.class);
    }

    @Override
    public void deleteAstudentById(long id) {
        if (!studentRepo.existsById(id)) {
            throw new IllegalArgumentException("Student not found with ID " + id);

        }
        studentRepo.deleteById(id);
    }

    @Override
    public StudDTO updatestudent(long id, AddstudReqDTO addstudReqDTO) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));
        modelMapper.map(addstudReqDTO, student);

        studentRepo.save(student);
        return modelMapper.map(student, StudDTO.class);
    }

    @Override
    public StudDTO updatePartialstudent(long id, Map<String, Object> update) {
        Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID " + id));

        update.forEach((feild , value) -> {
          switch (feild) {
            case "name":
                student.setName((String) value);
            break;
            case "email":
                student.setEmail((String) value);
            break;
              default: throw new IllegalArgumentException("feild is not supported");
          }
       });
        Student savestudent = studentRepo.save(student);
        return  modelMapper.map(student, StudDTO.class);
    }

}
