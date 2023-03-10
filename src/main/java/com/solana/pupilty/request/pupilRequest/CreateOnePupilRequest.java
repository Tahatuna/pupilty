package com.solana.pupilty.request.pupilRequest;

import lombok.Data;

@Data
public class CreateOnePupilRequest {

    private String userName;
    private String name;
    private String lastName;
    private String mail;
    private String telNo;
    private String password;

}
