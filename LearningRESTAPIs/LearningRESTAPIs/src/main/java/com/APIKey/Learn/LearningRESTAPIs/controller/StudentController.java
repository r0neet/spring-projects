package com.APIKey.Learn.LearningRESTAPIs.controller;

import com.APIKey.Learn.LearningRESTAPIs.DTO.AddstudReqDTO;
import com.APIKey.Learn.LearningRESTAPIs.DTO.StudDTO;
import com.APIKey.Learn.LearningRESTAPIs.service.StudService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudService studService;

    @GetMapping("/students")                 // get request
    public ResponseEntity<List<StudDTO>> getAllStudent(){             //this is the method - returns student (buisness logic)
        //return ResponseEntity.status(HttpStatus.OK).body(StudService.getAllStudent());    //use ResponseEntity because it lets u add status of HTTp request with a body and many more things
        return ResponseEntity.ok(studService.getAllStudent());  // shorthand technic to add status
    }

    @GetMapping("/students/{id}")                 // get request                // a second method example which can be mapped
    public ResponseEntity<StudDTO> getStudentbyId(@PathVariable("id") long id) {             //this is the method - returns student
        return ResponseEntity.ok(studService.getStudentbyId(id));                 //a path variable was made just so that when id is found it get injected in function
    }

    @PostMapping("/students")//post request - to enter new data
    public ResponseEntity<StudDTO> createstudent(@RequestBody AddstudReqDTO addstudReqDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studService.createnewstudent(addstudReqDTO));
    }

    @DeleteMapping("/students/{id}")                    //delete request
    public ResponseEntity<Void> deleteAstudent(@PathVariable long id){
        studService.deleteAstudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/students/{id}")           // update data request
    public ResponseEntity<StudDTO> updatestudent(@PathVariable long id, @RequestBody AddstudReqDTO addstudReqDTO){
        return ResponseEntity.ok(studService.updatestudent(id, addstudReqDTO));
    }

    @PatchMapping("/students/{id}")
    public ResponseEntity<StudDTO> updatePartialstudent(@PathVariable long id, @RequestBody Map<String, Object> update){
        return ResponseEntity.ok(studService.updatePartialstudent(id, update));
    }
}
