package com.example.emsapi.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeResponseError {

    private int status;
    private String message;
    private long timeStamp;
}