package com.demisco.project.projection;

/**
 * Spring Data Projection:
 *
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#projections">Spring Data JPA Documentation</a>
 */
public interface BestSellers {
    Integer getAlbumId();

    String getAlbumName();

    String getAlbumGenre();

    Integer getSalesNumber();
}