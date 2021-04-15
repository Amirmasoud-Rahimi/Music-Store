package com.demisco.project.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Item Not Found!")
public class ItemNotFoundException extends RuntimeException { }