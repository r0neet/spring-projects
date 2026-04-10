package com.APIKey.Learn.LearningRESTAPIs.repository;

import com.APIKey.Learn.LearningRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//this is where all the data base queries will be written
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
}
