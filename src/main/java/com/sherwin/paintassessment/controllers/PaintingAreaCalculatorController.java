package com.sherwin.paintassessment.controllers;

import com.sherwin.paintassessment.models.PaintingAreaResponse;
import com.sherwin.paintassessment.models.Room;
import com.sherwin.paintassessment.services.PaintingAreaCalculatorService;
import com.sherwin.paintassessment.utils.RoomValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaintingAreaCalculatorController {

    private final RoomValidator roomValidator;
    private final PaintingAreaCalculatorService paintingAreaCalculatorService;


    @PostMapping("paint/calculate/room")
    public ResponseEntity<PaintingAreaResponse> calculatePaintingArea(@Valid @RequestBody Room room) {
        PaintingAreaResponse paintingAreaResponse = new PaintingAreaResponse();

        List<String> errors = new ArrayList<>();
        roomValidator.validate(room, errors);
        if (!errors.isEmpty()) {
            paintingAreaResponse.setErrors(errors);
            return new ResponseEntity<>(paintingAreaResponse, HttpStatus.BAD_REQUEST);
        }
        double area = paintingAreaCalculatorService.calculatePaintableArea(room);
        paintingAreaResponse.setArea(area);

        return new ResponseEntity<>(paintingAreaResponse, HttpStatus.OK);
    }
}
