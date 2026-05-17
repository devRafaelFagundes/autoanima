package com.ieka.autoanima.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String audioLink;

    private String videoLink;

    private String status;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "projects")
    Set<ImagePackage> imagePackages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}