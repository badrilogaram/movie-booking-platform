package com.badri.booking_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class ShowResponse {
    private Long showId;
    private String theatreName;
    private LocalTime showTime;
}