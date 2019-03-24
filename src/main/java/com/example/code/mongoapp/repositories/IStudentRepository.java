package com.example.code.mongoapp.repositories;

import com.example.code.mongoapp.models.Student;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * IStudentRepository
 */
public interface IStudentRepository extends MongoRepository<Student, String> {
    Student findBy_id(ObjectId _id);
}