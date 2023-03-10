package com.solana.pupilty.response;

import com.solana.pupilty.enums.SubscriptionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginPupilResponse  {

    private Long id;
    private String userName;
    private SubscriptionStatus subscriptionStatus;

}
