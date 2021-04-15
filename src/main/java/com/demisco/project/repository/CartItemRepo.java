package com.demisco.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.demisco.project.projection.BestSellers;
import org.springframework.stereotype.Repository;
import com.demisco.project.model.*;

@Repository
public interface CartItemRepo extends CrudRepository<CartItem, Integer> {
    //This Query Select the Best-Selling Music Albums According to a Specific Date , Based On Genre.
    @Query(value = "SELECT c.music_album_id AS albumId, m.album_name AS albumName,SUM(c.quantity) AS salesNumber,g.name AS albumGenre " +
            "FROM cart_item c " +
            "INNER JOIN music_album m ON m.album_id=c.music_album_id " +
            "INNER JOIN genre g ON m.genre_id=g.genre_id " +
            "INNER JOIN orders o ON c.order_id=o.orders_id  " +
            "WHERE m.genre_id=?1 AND o.order_date >=?2 AND  o.order_date <=?3  " +
            "GROUP BY music_album_id " +
            "ORDER BY SUM(quantity) DESC LIMIT 1", nativeQuery = true)
    BestSellers findByAlbumGenreAndDate(Integer genreId, String startDate, String endDate);

    //This Query Select the Best-Selling Music Albums Totally Based On Genre.
    @Query(value = "SELECT c.music_album_id AS albumId, m.album_name AS albumName,SUM(c.quantity) AS salesNumber,g.name AS albumGenre " +
            "FROM cart_item c " +
            "INNER JOIN music_album m ON m.album_id=c.music_album_id " +
            "INNER JOIN genre g ON m.genre_id=g.genre_id " +
            "WHERE m.genre_id=?1\n" +
            "GROUP BY music_album_id\n" +
            "ORDER BY SUM(quantity) DESC LIMIT 1", nativeQuery = true)
    BestSellers findByAlbumGenre(Integer genreId);
}