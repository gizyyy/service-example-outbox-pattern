package com.example.gizem.yilmaz.infrastructure.repository;

import com.example.gizem.yilmaz.domain.Student;
import com.example.gizem.yilmaz.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StudentDataMongoRepository implements StudentRepository {

    private final StudentMongoRepository studentMongoRepository;

    public Student save(Student student) {
        return studentMongoRepository.save(student);
    }

}
