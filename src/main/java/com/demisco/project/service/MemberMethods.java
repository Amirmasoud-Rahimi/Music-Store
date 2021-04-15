package com.demisco.project.service;

import com.demisco.project.exception.ItemNotFoundException;
import com.demisco.project.repository.*;
import com.demisco.project.model.*;

import java.util.List;
import java.sql.Date;

public class MemberMethods {
    public static MembersVote setMembersVote(MusicAlbumRepo musicAlbumRepo, MembersVoteRepo membersVoteRepo, Integer albumId, User user) {
        MusicAlbum musicAlbum = musicAlbumRepo.findById(albumId).orElseThrow(ItemNotFoundException::new);
        Date date = new Date(new java.util.Date().getTime());
        List<MembersVote> membersVotes = membersVoteRepo.findAllByUserAndAlbumGenre(user, musicAlbum.getGenre().getName());
        if (membersVotes != null) {
            membersVoteRepo.memberVoteValidate(membersVotes);
        }
        return new MembersVote(date, musicAlbum.getGenre().getName(), user, musicAlbum);
    }
}