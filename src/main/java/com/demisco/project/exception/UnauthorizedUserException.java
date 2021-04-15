package com.demisco.project.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Unauthorized Access.Please First Login!")
public class UnauthorizedUserException extends RuntimeException { }