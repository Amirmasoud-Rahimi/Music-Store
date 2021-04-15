package com.demisco.project.projection;

/**
 * Spring Data Projection:
 *
 * @see BestSellers to More Information about Spring Data Projection
 */
public interface BestVotes {
    String getAlbumName();

    String getAlbumGenre();

    Integer getNumberOfVotes();
}