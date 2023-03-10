package com.solana.pupilty.entities;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "educater")
@Getter
@Setter
public class Educater {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    @JsonIgnore
    private String password;
    private String name;
    private String lastName;
    @Lob
    @Column(columnDefinition = "text")
    private String profileDesc;
    private String mail;
    private String telNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private ProfileImage image;

    @OneToMany(mappedBy = "educater")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Lesson> lessons = new ArrayList<>();


}
