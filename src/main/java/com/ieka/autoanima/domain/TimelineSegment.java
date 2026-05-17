package com.ieka.autoanima.domain;

import jakarta.persistence.*;

@Entity
public class TimelineSegment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long startTime;

    private Long endTime;

    private String emotion;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "selected_image_id")
    private Image selectedImage;
}