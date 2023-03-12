package com.solana.pupilty.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.solana.pupilty.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lesson")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lessonName;
    @Lob
    @Column(columnDefinition = "text")
    private String description;
    private String price;
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "educater_id", nullable = false)
    private Educater educater;


}
