package com.demisco.project.model;

import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Genre {
    private Integer genreId;
    private String name;

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getGenreId() {
        return genreId;
    }

    private void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @NotNull
    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreId.equals(genre.genreId) &&
                Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, name);
    }
}