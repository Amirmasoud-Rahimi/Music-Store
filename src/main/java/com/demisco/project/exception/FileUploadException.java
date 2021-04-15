package com.demisco.project.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import java.io.IOException;

@ResponseStatus(value = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, reason = "Invalid File!")
public class FileUploadException extends IOException { }