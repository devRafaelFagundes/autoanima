package com.ieka.autoanima.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String imageLink;

    private String emotion;

    @ManyToMany
    @JoinTable(
            name = "image_and_image_package",
            joinColumns = @JoinColumn(name = "image_id"),
            inverseJoinColumns = @JoinColumn(name = "image_package_id")
    )
    private Set<ImagePackage> imagePackages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}