package com.sherwin.paintassessment.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaintingAreaResponse {

    private Double area;
    private List<String> errors;
}
