package com.ieka.autoanima.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class ImagePackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "project_image_package",
            joinColumns = @JoinColumn(name = "image_package_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    Set<Project>  projects;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}