package com.demisco.project.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.slf4j.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;

@Controller
@RequestMapping("/error")
// For Errors That Not Handled By MainExceptionHandler
public class ErrorsController implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorsController.class);

    @GetMapping
    public ModelAndView errorsController(HttpServletRequest request) {
        ModelAndView model;
        String url, reason;
        int statusCode = 0;
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) statusCode = Integer.parseInt(status.toString());
        url = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI).toString();
        reason = request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString();
        switch (statusCode) {
            case 403:
                model = new ModelAndView("error/forbidden-403");
                break;
            case 404:
                reason = "Item Not Found";
                model = new ModelAndView("error/notFound-404");
                break;
            case 416:
                reason = "File Not Found";
                model = new ModelAndView("error/error");
                break;
            case 500:
                reason = "An Error Has Occurred";
                model = new ModelAndView("error/server-500");
                break;
            default:
                model = new ModelAndView("error/error");
        }
        LOGGER.error("Reason: " + reason + " & " + "Failed URL: " + url);
        model.addObject("url", url);
        model.addObject("reason", reason);
        return model;
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}