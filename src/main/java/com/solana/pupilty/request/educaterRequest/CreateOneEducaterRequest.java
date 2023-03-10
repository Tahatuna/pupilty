package com.solana.pupilty.request.educaterRequest;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CreateOneEducaterRequest {

    private String userName;
    private String password;
    private String name;
    private String lastName;
    @Lob
    private String profileDesc;
    private String mail;
    private String telNo;

}
