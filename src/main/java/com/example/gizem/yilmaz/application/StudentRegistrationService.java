package com.example.gizem.yilmaz.application;

import com.example.gizem.yilmaz.domain.Student;
import com.example.gizem.yilmaz.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentRegistrationService {

    private final StudentRepository studentRepository;

    @Transactional
    public Student register(final Student student) {
        log.info("Student with {} saved", kv("studentId", student.getStudentId()));
        return studentRepository.save(student);
    }
}
