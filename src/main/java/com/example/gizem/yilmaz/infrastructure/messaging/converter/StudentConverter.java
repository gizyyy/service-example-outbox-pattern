package com.example.gizem.yilmaz.infrastructure.messaging.converter;

import com.example.gizem.yilmaz.domain.Student;
import com.example.gizem.yilmaz.infrastructure.messaging.StudentAddedEvent;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {
    public Student convert(StudentAddedEvent event) {
        return Student.from(event.studentId(), event.studentName(), event.occurredAt());
    }


}
