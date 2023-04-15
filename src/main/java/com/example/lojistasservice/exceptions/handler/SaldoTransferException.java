package com.example.lojistasservice.exceptions.handler;


import lombok.Builder;

@Builder
public class SaldoTransferException extends RuntimeException {

    public SaldoTransferException(String msg) {
        super(msg);
    }
}
