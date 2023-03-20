package com.example.gizem.yilmaz.infrastructure.messaging;

import java.time.Instant;
import java.util.UUID;

public record StudentAddedEvent(UUID studentId, String studentName, Instant occurredAt) {
}
