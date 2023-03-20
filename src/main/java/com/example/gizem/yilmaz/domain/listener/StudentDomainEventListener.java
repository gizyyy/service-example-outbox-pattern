package com.example.gizem.yilmaz.domain.listener;

import com.example.gizem.yilmaz.domain.event.StudentAddedEvent;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import static net.logstash.logback.argument.StructuredArguments.kv;

@Component
@Slf4j
@RequiredArgsConstructor
public class StudentDomainEventListener {

    private final MeterRegistry meterRegistry;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void notify(StudentAddedEvent studentAddedEvent) {
        Counter.builder("translation-count").register(meterRegistry).increment();
        //supposed to listen domain events of the saved object, and send ecst, or events to outside
        log.info("StudentAddedEvent of {} is being emitted", kv("courierId", studentAddedEvent.studentId()));
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMPLETION)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void clean(StudentAddedEvent studentAddedEvent) {
        //supposed to work at last order, once everything is done, can be used for any purpose
        //if it's not going to do db operation no need for transactional, i assume here i need it
        log.info("I'm cleaning logic working after transaction is complete", kv("studentId", studentAddedEvent.studentId()));
    }
}
