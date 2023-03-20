package com.example.gizem.yilmaz.domain.event;

import java.time.Instant;
import java.util.UUID;

public record StudentAddedEvent(UUID studentId, String studentName, Instant occurredAt) {
}
