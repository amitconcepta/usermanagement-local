package com.usermanagement.spring.microservice.reports.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ErrorResponse {
    private String ErrorMessage;
    private String ErrorCode;
    private int status;
}
