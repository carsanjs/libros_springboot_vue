package com.example.libros.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.libros.models.bookModel;

@Repository
public interface bookRepository extends MongoRepository<bookModel, Integer> {

}
