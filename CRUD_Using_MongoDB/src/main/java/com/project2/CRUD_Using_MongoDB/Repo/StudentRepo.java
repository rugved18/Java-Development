package com.project2.CRUD_Using_MongoDB.Repo;

import com.project2.CRUD_Using_MongoDB.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
