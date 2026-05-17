package com.ieka.autoanima.domain;

import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageLink;

    private String emotion;

    @ManyToOne
    @JoinColumn(name = "image_package_id")
    private ImagePackage imagePackage;
}