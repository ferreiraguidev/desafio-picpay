package com.example.lojistasservice.exceptions.handler;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ExceptionFilters {
    private String message;
}
