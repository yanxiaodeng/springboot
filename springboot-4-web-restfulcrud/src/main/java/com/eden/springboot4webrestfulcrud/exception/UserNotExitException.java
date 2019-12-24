package com.eden.springboot4webrestfulcrud.exception;

public class UserNotExitException extends RuntimeException {
    public UserNotExitException() {
        super("用户不存在");
    }
}
