package com.demisco.project.model;

import javax.persistence.*;
import java.util.Objects;
import java.sql.Date;

@Entity
@Table(name = "members_vote")
public class MembersVote {
    private Integer memberVoteId;
    private Date voteDate;
    private String albumGenre;
    private User user;
    private MusicAlbum musicAlbum;

    @Id
    @Column(name = "members_vote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMemberVoteId() {
        return memberVoteId;
    }

    private void setMemberVoteId(Integer memberVoteId) {
        this.memberVoteId = memberVoteId;
    }

    @Column(name = "vote_date", nullable = false)
    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }

    @Column(name = "album_genre", nullable = false)
    public String getAlbumGenre() {
        return albumGenre;
    }

    public void setAlbumGenre(String albumGenre) {
        this.albumGenre = albumGenre;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "music_album_id", nullable = false)
    public MusicAlbum getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(MusicAlbum musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public MembersVote() {
    }

    public MembersVote(Date voteDate, String albumGenre, User user, MusicAlbum musicAlbum) {
        this.voteDate = voteDate;
        this.albumGenre = albumGenre;
        this.user = user;
        this.musicAlbum = musicAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembersVote that = (MembersVote) o;
        return Objects.equals(memberVoteId, that.memberVoteId) &&
                Objects.equals(voteDate, that.voteDate) &&
                Objects.equals(albumGenre, that.albumGenre) &&
                Objects.equals(user, that.user) &&
                Objects.equals(musicAlbum, that.musicAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberVoteId, voteDate, albumGenre, user, musicAlbum);
    }
}