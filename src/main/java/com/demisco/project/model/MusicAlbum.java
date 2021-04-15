package com.demisco.project.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

/**
 * @see User for More Information about @DynamicUpdate
 */
@Entity
@DynamicUpdate
@Table(name = "music_album")
public class MusicAlbum {
    private Integer albumId;
    private String albumName;
    private String releaseDate;
    private Double price;
    private String sampleSongUrl;
    private Artist artist;
    private Genre genre;
    private Set<String> images = new HashSet<>();
    private Set<CartItem> cartItems = new HashSet<>();

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAlbumId() {
        return albumId;
    }

    private void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Column(name = "album_name", unique = true, nullable = false)
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Column(name = "release_date", nullable = false)
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "sample_song_url")
    public String getSampleSongUrl() {
        return sampleSongUrl;
    }

    public void setSampleSongUrl(String sampleSongUrl) {
        this.sampleSongUrl = sampleSongUrl;
    }

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "album_image", joinColumns = @JoinColumn(name = "album_id"))
    @Column(name = "file_name", nullable = false)
    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    @OneToMany(mappedBy = "musicAlbum", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public MusicAlbum() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicAlbum that = (MusicAlbum) o;
        return albumId.equals(that.albumId) &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(albumName, that.albumName) &&
                Objects.equals(releaseDate, that.releaseDate) &&
                Objects.equals(sampleSongUrl, that.sampleSongUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, albumName, releaseDate, price, sampleSongUrl);
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }

    public void addImage(String imageAddress) {
        this.images.add(imageAddress);
    }
}