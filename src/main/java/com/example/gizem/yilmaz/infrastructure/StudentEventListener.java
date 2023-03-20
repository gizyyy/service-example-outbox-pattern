package com.example.gizem.yilmaz.infrastructure;

import com.example.gizem.yilmaz.application.StudentApplicationService;
import com.example.gizem.yilmaz.domain.Student;
import com.example.gizem.yilmaz.infrastructure.messaging.StudentAddedEvent;
import com.example.gizem.yilmaz.infrastructure.messaging.converter.StudentConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class StudentEventListener {

    private final StudentApplicationService applicationService;

    private final StudentConverter converter;

    @Bean
    public Consumer<Message<StudentAddedEvent>> handleStudent() {
        return message -> {
            StudentAddedEvent studentAddedEvent = message.getPayload();
            Student student = converter.convert(studentAddedEvent);
            applicationService.process(student);
        };
    }

}
