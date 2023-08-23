package com.sherwin.paintassessment.services;

import com.sherwin.paintassessment.models.*;
import org.springframework.stereotype.Service;

@Service
public class PaintingAreaCalculatorService {
    public double calculatePaintableArea(Room room) {
        double totalPaintableArea = 0;

        for (Wall wall : room.getWalls()) {
            totalPaintableArea += getArea(wall.getLength(), wall.getHeight());
        }

        for (Window window : room.getWindows()) {
            totalPaintableArea -= getArea(window.getLength(), window.getHeight());
        }
        for (Door door : room.getDoors()) {
            totalPaintableArea -= getArea(door.getLength(), door.getHeight());
        }
        // My assumption trim is same as Door color
        for (Trim trim : room.getTrims()) {
            totalPaintableArea -= getArea(trim.getLength(), trim.getHeight());
        }

        return totalPaintableArea;
    }

    private double getArea(double length, double height) {
        return length * height;
    }
}


