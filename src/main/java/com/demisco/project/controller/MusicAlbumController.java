package com.demisco.project.controller;

import com.demisco.project.exception.ItemNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.demisco.project.repository.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/musicAlbum")
public class MusicAlbumController {
    private MusicAlbumRepo musicAlbumRepo;
    private GenreRepo genreRepo;

    public MusicAlbumController(MusicAlbumRepo musicAlbumRepo, GenreRepo genreRepo) {
        this.musicAlbumRepo = musicAlbumRepo;
        this.genreRepo = genreRepo;
    }

    @GetMapping
    public String musicAlbumsPage(Model model) {
        model.addAttribute("genres", genreRepo.findAll());
        return "musicAlbum";
    }

    @GetMapping("/{genre}")
    public String musicAlbumsByGenre(@PathVariable String genre, Model model) {
        model.addAttribute("albums", musicAlbumRepo.findByGenreName(genre));
        model.addAttribute("genre", genre);
        return "musicAlbum";
    }

    @GetMapping("/{albumId}/{genreName}")
    public String musicAlbumDetails(@PathVariable Integer albumId, @PathVariable String genreName, Model model) {
        model.addAttribute("album", musicAlbumRepo.findById(albumId).orElseThrow(ItemNotFoundException::new));
        model.addAttribute("albums", musicAlbumRepo.findByGenreName(genreName));
        model.addAttribute("genre", genreName);
        return "musicAlbum";
    }

    @GetMapping("/search")
    public String searchResult(Model model, @RequestParam(required = false) String keyWord) {
        if (keyWord != null)
            model.addAttribute("foundAlbums", musicAlbumRepo.findAllByAlbumNameContains(keyWord));
        model.addAttribute("search", "search");
        return "musicAlbum";
    }
}