package com.solana.pupilty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "fimage_table")
@Getter
@Setter
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Long id;
    String fileName;
    String fileType;

    @Lob
    @Column(length = 100000)
    private byte[] imageByte;

    @OneToOne(mappedBy = "image")
    @JsonIgnore
    private Educater educater;

    public ProfileImage(String fileName, String fileType, byte[] imageByte) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.imageByte = imageByte;
    }


}
