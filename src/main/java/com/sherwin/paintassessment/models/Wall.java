package com.sherwin.paintassessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wall {

    @Min(value = 0, message = "Wall length must be positive")
    private double length;
    @Min(value = 0, message = "Wall height must be positive")
    private double height;


}
