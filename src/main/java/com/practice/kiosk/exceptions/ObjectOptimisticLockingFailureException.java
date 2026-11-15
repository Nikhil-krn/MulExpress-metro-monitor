package com.practice.kiosk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ObjectOptimisticLockingFailureException extends RuntimeException {

    public ObjectOptimisticLockingFailureException(String msg){ super(msg); }
}
