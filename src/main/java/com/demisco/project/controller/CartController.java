package com.demisco.project.controller;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.demisco.project.exception.ItemNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.demisco.project.service.CartMethods;
import com.demisco.project.repository.*;
import org.springframework.ui.Model;
import com.demisco.project.model.*;
import com.demisco.project.bean.*;

import javax.servlet.http.HttpSession;
import java.sql.Date;

@Controller
@RequestMapping("/cart")
public class CartController {
    private MusicAlbumRepo musicAlbumRepo;
    private OrderRepo orderRepo;

    public CartController(MusicAlbumRepo musicAlbumRepo, OrderRepo orderRepo) {
        this.musicAlbumRepo = musicAlbumRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping
    public String ShoppingTab(Model model) {
        model.addAttribute("shopping", "shoppingTab");
        return "member/member";
    }

    @GetMapping("/add/{albumId}/{genre}")
    public String addItem(@SessionAttribute Cart cart, @PathVariable Integer albumId, @PathVariable String genre, Model model) {
        cart.addItem(musicAlbumRepo.findById(albumId).orElseThrow(ItemNotFoundException::new));
        model.addAttribute("addToCartSuccessfully", "Item Add To Cart Successfully");
        model.addAttribute("albums", musicAlbumRepo.findByGenreName(genre));
        model.addAttribute("genre", genre);
        return "musicAlbum";
    }

    @GetMapping("/remove/{albumId}")
    public String removeItem(@SessionAttribute Cart cart, @PathVariable Integer albumId, Model model) {
        cart.removeItem(albumId, musicAlbumRepo.findById(albumId).orElseThrow(ItemNotFoundException::new));
        model.addAttribute("shopping", "shoppingTab");
        return "member/member";
    }

    @GetMapping("/update")
    public String updateQuantity(@SessionAttribute Cart cart, Integer albumId, Integer quantity, Model model) {
        if (quantity <= 0) {
            removeItem(cart, albumId, model);
            return "member/member";
        }
        cart.updateQuantity(albumId, quantity, musicAlbumRepo.findById(albumId).orElseThrow(ItemNotFoundException::new));
        model.addAttribute("shopping", "shoppingTab");
        return "member/member";
    }

    @GetMapping("/checkOut/{totalPrice}")
    public String checkOutPage(@SessionAttribute Cart cart, @PathVariable Double totalPrice, Model model) {
        model.addAttribute("date", new Date(new java.util.Date().getTime()));
        model.addAttribute("customerAddress", new CustomerAddress());
        model.addAttribute("items", cart.getCartItems());
        model.addAttribute("order", new Orders());
        model.addAttribute("total", totalPrice);
        return "member/member";
    }

    @PostMapping("/checkOut")
    public String checkOut(@SessionAttribute Cart cart, HttpSession session, Orders orders, CustomerAddress address, RedirectAttributes model) {
        orderRepo.save(CartMethods.completeOrder(cart, orders, address, session));
        session.removeAttribute("cart");
        model.addFlashAttribute("orderSuccessfullyRegistered", "Order Successfully Registered. Thanks for your purchase");
        return "redirect:/member";
    }
}