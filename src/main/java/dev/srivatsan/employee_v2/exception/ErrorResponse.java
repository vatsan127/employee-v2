package dev.srivatsan.employee_v2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String message;
    private int status;
}
