package com.example.lojistasservice.exceptions;

import lombok.Builder;

@Builder
public class LojistaTransferException extends RuntimeException {

    public LojistaTransferException(String msg) {
        super(msg);
    }
}
