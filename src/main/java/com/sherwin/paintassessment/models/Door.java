package com.sherwin.paintassessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Door {

    @Min(value = 0, message = "Door length must be positive")
    private double length;
    @Min(value = 0, message = "Door height must be positive")
    private double height;

}
