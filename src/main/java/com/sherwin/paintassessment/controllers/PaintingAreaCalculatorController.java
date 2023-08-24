package com.sherwin.paintassessment.controllers;

import com.sherwin.paintassessment.models.PaintingAreaResponse;
import com.sherwin.paintassessment.models.Room;
import com.sherwin.paintassessment.services.PaintingAreaCalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@Tag(name = "Painting Area Calculator", description = "This controller represents the calculations of the Paint required for the Room")
public class PaintingAreaCalculatorController {

    private final PaintingAreaCalculatorService paintingAreaCalculatorService;


    @Operation(summary = " Painting Area Calculator", description = "The API represents the amount of paint required for the Room")
    @PostMapping("paint/calculate/room")
    public ResponseEntity<PaintingAreaResponse> calculatePaintingArea(@RequestBody @Valid Room room) {
        PaintingAreaResponse paintingAreaResponse = new PaintingAreaResponse();

        List<String> errors = new ArrayList<>();
        double area = paintingAreaCalculatorService.calculatePaintableArea(room);
        paintingAreaResponse.setArea(area);

        return new ResponseEntity<>(paintingAreaResponse, HttpStatus.OK);
    }
}
