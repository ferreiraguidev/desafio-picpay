package com.example.lojistasservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="verification" ,url="https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6")
public interface VerificationClient {

    @GetMapping
    VerificationDTO getVerification();
}
