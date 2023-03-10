package com.solana.pupilty.response;

import lombok.Data;

@Data
public class Response {

    public Response(String messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    private String messageCode;
    private String message;

}
