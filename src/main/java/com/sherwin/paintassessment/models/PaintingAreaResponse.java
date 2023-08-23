package com.sherwin.paintassessment.models;

import lombok.Data;

import java.util.List;

@Data
public class PaintingAreaResponse {
    private Double area;
    private List<String> errors;
}
