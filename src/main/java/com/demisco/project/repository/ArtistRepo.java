package com.demisco.project.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.demisco.project.model.Artist;

@Repository
public interface ArtistRepo extends PagingAndSortingRepository<Artist, Integer> { }