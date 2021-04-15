package com.demisco.project.model;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class Artist {
    private Integer artistId;
    private String firstName;
    private String lastName;
    private String nickName;

    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getArtistId() {
        return artistId;
    }

    private void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Pattern(regexp = ".*\\S+.*", message = "Invalid Input!")
    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Pattern(regexp = ".*\\S+.*", message = "Invalid Input!")
    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Size(max = 20, message = "Input Should Not Be More Than 20 Character!")
    @Pattern(regexp = ".*\\S+.*", message = "Invalid Input!")
    @Column(name = "nick_name", unique = true, nullable = false)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Artist() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artistId.equals(artist.artistId) &&
                Objects.equals(firstName, artist.firstName) &&
                Objects.equals(lastName, artist.lastName) &&
                Objects.equals(nickName, artist.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, firstName, lastName, nickName);
    }
}