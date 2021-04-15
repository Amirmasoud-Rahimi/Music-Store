package com.demisco.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demisco.project.model.Genre;

@Repository
public interface GenreRepo extends CrudRepository<Genre, Integer> { }