package com.sherwin.paintassessment.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class PaintingAreaResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double area;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;
}
