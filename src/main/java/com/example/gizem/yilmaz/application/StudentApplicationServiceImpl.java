package com.example.gizem.yilmaz.application;

import com.example.gizem.yilmaz.domain.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentApplicationServiceImpl implements StudentApplicationService {

    private final StudentRegistrationService studentRegistrationService;

    @Override
    public void process(Student student) {
        studentRegistrationService.register(student);
    }

}
