package com.sherwin.paintassessment.utils;

import com.sherwin.paintassessment.models.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomValidator {
    public void validate(Room room, List<String> errors) {
        List<Wall> walls = room.getWalls();
        if (walls.isEmpty()) {
            errors.add("Room should have walls");
        }
        List<Door> doors = room.getDoors();
        if (doors.isEmpty()) {
            errors.add("Room should have Door");
        }
        List<Window> windows = room.getWindows();
        if (windows.isEmpty()) {
            errors.add("Room should have Windows");
        }
        // If Trims optional then we need remove the below validation
        List<Trim> trims = room.getTrims();
        if (trims.isEmpty()) {
            errors.add("Room should have Trims");
        }
    }
}
