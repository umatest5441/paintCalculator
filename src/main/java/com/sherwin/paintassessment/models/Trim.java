package com.sherwin.paintassessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trim {

    @Min(value = 0, message = "Trim length must be positive")
    private double length;
    @Min(value = 0, message = "Trim height must be positive")
    private double height;

}
