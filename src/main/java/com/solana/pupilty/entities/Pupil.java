package com.solana.pupilty.entities;

import com.solana.pupilty.enums.SubscriptionStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static com.solana.pupilty.enums.SubscriptionStatus.NOT_SUBSCRIBED;

@Entity
@Table(name = "pupils")
@Getter
@Setter
public class Pupil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String userName;
    private String password;
    private String name;
    private String lastName;
    private String mail;
    private String telNo;
    private SubscriptionStatus subscriptionStatus;

}
