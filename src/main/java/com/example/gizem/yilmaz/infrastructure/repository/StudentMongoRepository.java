package com.example.gizem.yilmaz.infrastructure.repository;

import com.example.gizem.yilmaz.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentMongoRepository extends MongoRepository<Student, UUID> {
}
