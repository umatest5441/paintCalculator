package com.sherwin.paintassessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Door {

    @Size(min=1)
    private double length;
    @Size(min=1)
    private double height;

}
