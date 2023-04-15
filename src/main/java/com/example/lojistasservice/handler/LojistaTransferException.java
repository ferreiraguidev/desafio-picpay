package com.example.lojistasservice.handler;

import lombok.Builder;

@Builder
public class LojistaTransferException extends RuntimeException {

    public LojistaTransferException(String msg) {
        super(msg);
    }
}
