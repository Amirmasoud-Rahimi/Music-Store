package com.demisco.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.demisco.project.projection.BestVotes;
import com.demisco.project.model.*;

import java.util.List;

@Repository
public interface MembersVoteRepo extends CrudRepository<MembersVote, Integer>, CustomizedMembersVoteRepo {
    //This Query Select All The Votes That The User Has Given to Music Albums in This Genre
    List<MembersVote> findAllByUserAndAlbumGenre(User user, String albumGenre);

    //This Query Select The Best Music Album Based On User Votes in Each Genre
    @Query(value = "SELECT m.album_name AS albumName,g.name AS albumGenre,COUNT(v.music_album_id) AS numberOfVotes " +
            "FROM members_vote v " +
            "INNER JOIN music_album m ON v.music_album_id=m.album_id " +
            "INNER JOIN genre g ON m.genre_id=g.genre_id " +
            "WHERE album_genre=?1 " +
            "GROUP BY music_album_id " +
            "order by COUNT(music_album_id) desc limit 1", nativeQuery = true)
    BestVotes findByAlbumGenre(String albumGenre);
}