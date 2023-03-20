package com.example.gizem.yilmaz.application;

import com.example.gizem.yilmaz.domain.Student;
import com.example.gizem.yilmaz.infrastructure.messaging.StudentAddedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.cloudevent.CloudEventMessageBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentProvider {
    private final StreamBridge streamBridge;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendUnpaidOrder() {
        Message<StudentAddedEvent> message = CloudEventMessageBuilder
                .withData(new StudentAddedEvent(UUID.randomUUID(), "studentName", null))
                .setHeader("partitionKey", "manual")
                .build();

        log.info("Student is being send...");
        streamBridge.send("handleStudent-in-0", message);
    }
}