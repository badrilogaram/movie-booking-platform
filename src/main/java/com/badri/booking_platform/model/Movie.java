package com.badri.booking_platform.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String language;
    private String genre;
}