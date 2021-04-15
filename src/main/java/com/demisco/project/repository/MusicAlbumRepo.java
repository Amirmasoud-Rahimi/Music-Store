package com.demisco.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.demisco.project.model.MusicAlbum;

import java.util.List;

@Repository
public interface MusicAlbumRepo extends CrudRepository<MusicAlbum, Integer> {
    List<MusicAlbum> findByGenreName(String genre);

    //Search Music Albums By Name Or Part of a Name
    List<MusicAlbum> findAllByAlbumNameContains(String albumName);
}