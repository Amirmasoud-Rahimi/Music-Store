package com.demisco.project.exception;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.slf4j.*;

@ControllerAdvice
public class MainExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainExceptionHandler.class);

    @ExceptionHandler(InvalidNumberException.class)
    public String invalidNumberHandler(RedirectAttributes model) {
        LOGGER.error("admin Profile:membersPagination (Reason:Number Must Not Be Less Than One!)");
        model.addFlashAttribute("InvalidNumber", "Number Must Not Be Less Than One!");
        return "redirect:/admin/members";
    }

    @ExceptionHandler(DuplicateImageException.class)
    public String duplicateImageHandler(RedirectAttributes model) {
        LOGGER.error("admin Profile:Add Image to Album (Reason:Image Address Already Exists!)");
        model.addFlashAttribute("duplicateImage", "Image Address Already Exists! Try Another");
        return "redirect:/admin/addImage";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundHandler(Model model) {
        LOGGER.error("Authentication:Profile Recovery(Reason:User Not Found With This Profile!)");
        model.addAttribute("userNotFound", "User Not Found With This Profile! Please Register");
        return "profileRecovery";
    }

    @ExceptionHandler(InvalidVoteException.class)
    public String invalidVoteHandler(RedirectAttributes model, InvalidVoteException ex) {
        LOGGER.error("musicAlbum:Set Vote for Album(Reason:User Not Allowed To Vote For This Genre!)");
        model.addFlashAttribute("invalidVote", "You Are Not Allowed To Vote For This Genre Until " + ex.getMessage());
        return "redirect:/musicAlbum";
    }

    @ExceptionHandler(InvalidInputException.class)
    public String invalidInputHandler(Model model, InvalidInputException in) {
        String url;
        switch (in.getStackTrace()[1].getMethodName()) {
            case "userLogin":
                LOGGER.error("authentication:User Login(Reason:Invalid UserName Or Password!)");
                model.addAttribute("invalidInput", "Invalid UserName Or Password! Try Again");
                model.addAttribute("userR", "userRole");
                url = "login";
                break;
            case "adminLogin":
                LOGGER.error("authentication:Admin Login(Reason:Invalid UserName Or Password!)");
                model.addAttribute("invalidInput", "Invalid UserName Or Password! Try Again");
                model.addAttribute("adminR", "adminRole");
                url = "login";
                break;
            default:
                url = "Music";
                break;
        }
        return url;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public String duplicateRecordHandler(RedirectAttributes model, ConstraintViolationException ex) {
        String url;
        switch (ex.getConstraintName()) {
            case "genre_name_UNIQUE":
                LOGGER.error("admin Profile:Add Genre(Reason:Genre Name Already Exists!)");
                model.addFlashAttribute("duplicateGenre", "Genre Name Already Exists! Try Another");
                url = "redirect:/admin/genres";
                break;
            case "album_name_UNIQUE":
                LOGGER.error("admin Profile:Add Music Album(Reason:Music Album Name Already Exists!)");
                model.addFlashAttribute("duplicateAlbum", "Music Album Name Already Exists! Try Another!");
                url = "redirect:/admin/addAlbum";
                break;
            case "nick_name_UNIQUE":
                LOGGER.error("admin Profile:Add Artist(Reason:Artist Nick Name Already Exists!)");
                model.addFlashAttribute("duplicateArtist", "Artist Nick Name Already Exists! Try Another!");
                url = "redirect:/admin/addArtist";
                break;
            case "user_name_UNIQUE":
                LOGGER.error("authentication:Register(Reason:User Name Already Exists!)");
                model.addFlashAttribute("duplicateUsername", "User Name Already Exists! Try Another");
                url = "redirect:/authenticate/register";
                break;
            case "email_UNIQUE":
                LOGGER.error("authentication:Register(Reason:Email Address Already Exists!)");
                model.addFlashAttribute("duplicateEmail", "Email Address Already Exists! Try Another");
                url = "redirect:/authenticate/register";
                break;
            default:
                url = "Music";
        }
        return url;
    }
}