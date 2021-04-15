package com.demisco.project.exception;

public class InvalidVoteException extends RuntimeException {
    public InvalidVoteException(String message) {
        super(message);
    }
}