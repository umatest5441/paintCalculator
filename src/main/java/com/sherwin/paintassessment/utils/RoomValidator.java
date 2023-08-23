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
        if (errors.isEmpty()) {
            for (Wall wall : walls) {
                validateLengthAndHeight("wall", wall.getLength(), wall.getHeight(), errors);
            }
            for (Door door : doors) {
                validateLengthAndHeight("door", door.getLength(), door.getHeight(), errors);
            }
            for (Window window : windows) {
                validateLengthAndHeight("window", window.getLength(), window.getHeight(), errors);
            }
            for (Trim trim : trims) {
                validateLengthAndHeight("trim", trim.getLength(), trim.getHeight(), errors);
            }
        }
    }

    private void validateLengthAndHeight(String roomProperty, double length, double height, List<String> errors) {
        if (length <= 0) {
            errors.add(roomProperty + " length must be greater than 0.");
        }
        if (height <= 0) {
            errors.add(roomProperty + " height must be greater than 0.");
        }
    }
}
