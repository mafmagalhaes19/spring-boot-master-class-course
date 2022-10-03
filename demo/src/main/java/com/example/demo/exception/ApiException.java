package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//Creates everything - getters, constructor, toString
//@Data

//Class converted to a record
//private final, getter, public constructor, equals, hashcode and toString
public record ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
    /*public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.zonedDateTime = zonedDateTime;
    }

    public String getMessage(){
        return message;
    }

    public Throwable getThrowable(){
        return throwable;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }*/

    /*public ZonedDateTime getZonedDateTime(){
        return zonedDateTime;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message='" + message + '\'' +
                ", throwable=" + throwable +
                ", httpStatus=" + httpStatus +
                ", zonedDateTime=" + zonedDateTime +
                '}';
    }*/
}
