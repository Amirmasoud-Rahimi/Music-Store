package com.demisco.project.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.demisco.project.service.AdminMethods;
import org.springframework.validation.Errors;
import com.demisco.project.repository.*;
import com.demisco.project.exception.*;
import org.springframework.ui.Model;
import com.demisco.project.model.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private MembersVoteRepo membersVoteRepo;
    private MusicAlbumRepo musicAlbumRepo;
    private CartItemRepo cartItemRepo;
    private ArtistRepo artistRepo;
    private GenreRepo genreRepo;
    private UserRepo userRepo;

    public AdminController(UserRepo userRepo, ArtistRepo artistRepo, GenreRepo genreRepo, MusicAlbumRepo musicAlbumRepo, MembersVoteRepo membersVoteRepo, CartItemRepo cartItemRepo) {
        this.membersVoteRepo = membersVoteRepo;
        this.musicAlbumRepo = musicAlbumRepo;
        this.cartItemRepo = cartItemRepo;
        this.artistRepo = artistRepo;
        this.genreRepo = genreRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String adminPage(HttpSession session) {
        if (session.getAttribute("admin") == null) throw new UnauthorizedUserException();
        return "admin/admin";
    }

    @GetMapping("/addArtist")
    public String addArtistTab(Model model) {
        model.addAttribute("artist", new Artist());
        return "admin/admin";
    }

    @PostMapping("/addArtist")
    public String addArtist(@Valid Artist artist, Errors errors, RedirectAttributes attributes, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("artist", artist);
            return "admin/admin";
        }
        artistRepo.save(artist);
        attributes.addFlashAttribute("artistAddedSuccessfully", "New Artist Added Successfully");
        return "redirect:/admin/addArtist";
    }

    @GetMapping("/addAlbum")
    public String addAlbumTab(Model model) {
        model.addAttribute("artists", artistRepo.findAll());
        model.addAttribute("musicAlbum", new MusicAlbum());
        model.addAttribute("genres", genreRepo.findAll());
        return "admin/admin";
    }

    @PostMapping("/addAlbum")
    public String addAlbum(@RequestPart MultipartFile sampleSong, RedirectAttributes model, MusicAlbum musicAlbum, Integer artistId, Integer genreId) throws FileUploadException {
        musicAlbum.setArtist(artistRepo.findById(artistId).orElseThrow(ItemNotFoundException::new));
        musicAlbum.setGenre(genreRepo.findById(genreId).orElseThrow(ItemNotFoundException::new));
        musicAlbum.setSampleSongUrl("/Music/resources/mp3/" + AdminMethods.addSampleSong(sampleSong));
        musicAlbumRepo.save(musicAlbum);
        model.addFlashAttribute("albumAddedSuccessfully", "New Music Album Added Successfully");
        return "redirect:/musicAlbum";
    }

    @GetMapping("/addImage")
    public String addImageTab(Model model) {
        model.addAttribute("albums", musicAlbumRepo.findAll());
        return "admin/admin";
    }

    @PostMapping("/addImage")
    public String addImage(@RequestPart MultipartFile albumImage, RedirectAttributes model, Integer albumId) throws FileUploadException {
        musicAlbumRepo.save(AdminMethods.addImage(albumImage, musicAlbumRepo, albumId));
        model.addFlashAttribute("imageAddedSuccessfully", "image Successfully Added To Music Album");
        return "redirect:/admin/addImage";
    }

    @GetMapping("/bestSellers")
    public String bestSellers(Model model) {
        model.addAttribute("bestSellers", "bestSellersTable");
        return "admin/admin";
    }

    @PostMapping("/bestSellers")
    public String bestSellersResult(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, RedirectAttributes model) {
        model.addFlashAttribute("result", AdminMethods.bestSellers(genreRepo, cartItemRepo, startDate, endDate));
        model.addFlashAttribute("startDate", startDate);
        model.addFlashAttribute("endDate", endDate);
        return "redirect:/admin/bestSellers";
    }

    @GetMapping("/genres")
    public String genresTab(Model model) {
        model.addAttribute("allGenres", genreRepo.findAll());
        model.addAttribute("genre", new Genre());
        return "admin/admin";
    }

    @PostMapping("/genres")
    public String addGenre(Genre genre) {
        genreRepo.save(genre);
        return "redirect:/admin/genres";
    }

    @GetMapping("/deleteGenre/{genreId}")
    public String deleteGenre(@PathVariable Integer genreId) {
        genreRepo.deleteById(genreId);
        return "redirect:/admin/genres";
    }

    @GetMapping("/members")
    public String membersByPagination(@RequestParam(defaultValue = "5") Integer maxResult, Model model) {
        if (maxResult < 1) throw new InvalidNumberException();
        model.addAttribute("membersPage", userRepo.findAll(PageRequest.of(0, maxResult)).toList());
        model.addAttribute("membersTab", "true");
        return "admin/admin";
    }

    @GetMapping("/artists/{page}")
    public String artistsByPagination(Model model, @PathVariable Integer page) {
        model.addAttribute("artists", artistRepo.findAll(PageRequest.of(page, 6)).toList());
        model.addAttribute("page", page);
        return "admin/admin";
    }

    @GetMapping("/membersVoteTable")
    public String membersVoteTable(Model model) {
        model.addAttribute("membersVote", AdminMethods.bestVotes(genreRepo, membersVoteRepo));
        return "admin/admin";
    }
}