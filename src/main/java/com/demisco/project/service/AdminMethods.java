package com.demisco.project.service;

import org.springframework.web.multipart.MultipartFile;
import com.demisco.project.projection.*;
import com.demisco.project.repository.*;
import com.demisco.project.exception.*;
import com.demisco.project.model.*;
import org.slf4j.*;

import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class AdminMethods {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminMethods.class);

    public static List<BestVotes> bestVotes(GenreRepo genreRepo, MembersVoteRepo membersVoteRepo) {
        List<BestVotes> bestVotesList = new ArrayList<>();
        for (Genre genre : genreRepo.findAll()) {
            BestVotes bestVotes = membersVoteRepo.findByAlbumGenre(genre.getName());
            if (bestVotes != null) bestVotesList.add(bestVotes);
        }
        return bestVotesList;
    }

    public static List<BestSellers> bestSellers(GenreRepo genreRepo, CartItemRepo cartItemRepo, String startDate, String endDate) {
        List<BestSellers> sellersList = new ArrayList<>();
        BestSellers bestSellers;
        for (Genre genre : genreRepo.findAll()) {
            if (startDate == null || endDate == null) {
                bestSellers = cartItemRepo.findByAlbumGenre(genre.getGenreId());
            } else {
                bestSellers = cartItemRepo.findByAlbumGenreAndDate(genre.getGenreId(), startDate, endDate);
            }
            if (bestSellers != null) sellersList.add(bestSellers);
        }
        return sellersList;
    }

    public static String addSampleSong(MultipartFile sampleSong) throws FileUploadException {
        try {
            File serverFile = new File(Paths.get("").toAbsolutePath().toString().replace('\\', '/') + "/src/main/webapp/resources/mp3/" + sampleSong.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(sampleSong.getBytes());
            stream.close();
        } catch (IOException ex) {
            LOGGER.error("Admin Methods:addSampleSong (Reason:" + ex.getMessage() + "!)");
            throw new FileUploadException();
        }
        return sampleSong.getOriginalFilename();
    }

    public static MusicAlbum addImage(MultipartFile image, MusicAlbumRepo musicAlbumRepo, Integer albumId) throws FileUploadException {
        try {
            File serverFile = new File(Paths.get("").toAbsolutePath().toString().replace('\\', '/') + "/src/main/webapp/resources/img/AlbumImages/" + image.getOriginalFilename());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(image.getBytes());
            stream.close();
        } catch (IOException ex) {
            LOGGER.error("Admin Methods:addImage (Reason:" + ex.getMessage() + "!)");
            throw new FileUploadException();
        }
        String url = "/Music/resources/img/AlbumImages/" + image.getOriginalFilename();
        MusicAlbum musicAlbum = musicAlbumRepo.findById(albumId).orElseThrow(ItemNotFoundException::new);
        if (musicAlbum.getImages().contains(url)) throw new DuplicateImageException();
        musicAlbum.addImage(url);
        return musicAlbum;
    }
}