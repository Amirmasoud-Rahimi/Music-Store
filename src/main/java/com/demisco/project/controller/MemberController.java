package com.demisco.project.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import com.demisco.project.service.MemberMethods;
import org.springframework.web.bind.annotation.*;
import com.demisco.project.repository.*;
import com.demisco.project.exception.*;
import com.demisco.project.bean.Cart;
import org.springframework.ui.Model;
import com.demisco.project.model.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@SessionAttributes("cart")
public class MemberController {
    private MembersVoteRepo membersVoteRepo;
    private MusicAlbumRepo musicAlbumRepo;
    private GenreRepo genreRepo;
    private UserRepo userRepo;

    public MemberController(MusicAlbumRepo musicAlbumRepo, MembersVoteRepo membersVoteRepo, GenreRepo genreRepo, UserRepo userRepo) {
        this.membersVoteRepo = membersVoteRepo;
        this.musicAlbumRepo = musicAlbumRepo;
        this.genreRepo = genreRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute("cart")
    public Cart createCart() {
        return new Cart();
    }

    @GetMapping
    public String memberProfile(HttpSession session) {
        if (session.getAttribute("member") == null) throw new UnauthorizedUserException();
        return "member/member";
    }

    @GetMapping("/memberInfo")
    public String memberInfo(Model model) {
        model.addAttribute("memberInfo", "true");
        return "member/member";
    }

    @GetMapping("/changePassword")
    public String passwordManagement(Model model) {
        model.addAttribute("password", "true");
        return "member/member";
    }

    @PostMapping("/changePassword")
    public String changePassword(RedirectAttributes model, String password, Integer memberId) {
        User user = userRepo.findById(memberId).orElseThrow(UserNotFoundException::new);
        user.setPassword(password);
        userRepo.save(user);
        model.addFlashAttribute("passwordSuccessfullyChanged", "The Password Was Successfully Changed");
        return "redirect:/authenticate/userLogin";
    }

    @GetMapping("/setVote/{albumId}")
    public String setVote(@SessionAttribute("member") User user, @PathVariable Integer albumId, RedirectAttributes model) {
        MembersVote membersVote = MemberMethods.setMembersVote(musicAlbumRepo, membersVoteRepo, albumId, user);
        membersVoteRepo.save(membersVote);
        model.addFlashAttribute("voteSetSuccessfully", "Your Vote On The " + membersVote.getMusicAlbum().getAlbumName() + " Successfully Submitted");
        return "redirect:/musicAlbum";
    }
}