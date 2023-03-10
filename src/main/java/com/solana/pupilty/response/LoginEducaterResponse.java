package com.solana.pupilty.response;

import lombok.Data;

@Data
public class LoginEducaterResponse {

    public LoginEducaterResponse(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    Long id;
    String userName;

}
