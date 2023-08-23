package com.sherwin.paintassessment;

import com.sherwin.paintassessment.models.*;

import java.util.ArrayList;
import java.util.List;

public class BasePaintingAreaCalculatorTest {
    protected Room getRoomWithOutWindowsAndTrims() {
        Room room = new Room();
        room.setWalls(getWalls());
        room.setDoors(getDoors());
        return room;
    }

    protected Room getRoomWithOutTrims() {
        Room room = new Room();
        room.setWalls(getWalls());
        room.setDoors(getDoors());
        room.setWindows(getWindows());
        return room;
    }

    protected Room getRoom() {
        Room room = new Room();
        room.setWalls(getWalls());
        room.setDoors(getDoors());
        room.setWindows(getWindows());
        room.setTrims(getTrims());
        return room;
    }

    private List<Wall> getWalls() {
        Wall wall1 = new Wall(10.0, 14.0);
        Wall wall2 = new Wall(10.0, 14.0);
        Wall wall3 = new Wall(12.0, 14.0);
        Wall wall4 = new Wall(12.0, 14.0);
        List<Wall> walls = new ArrayList<>();
        walls.add(wall1);
        walls.add(wall2);
        walls.add(wall3);
        walls.add(wall4);
        return walls;
    }

    private List<Door> getDoors() {
        List<Door> doors = new ArrayList<>();
        Door door = new Door(2.0, 6.0);
        doors.add(door);
        return doors;
    }

    private List<Window> getWindows() {
        List<Window> windows = new ArrayList<>();
        Window window = new Window(3.0, 3.0);
        windows.add(window);
        return windows;
    }

    private List<Trim> getTrims() {
        List<Trim> trims = new ArrayList<>();
        Trim trim1 = new Trim(0.05, 6.0);
        Trim trim2 = new Trim(0.05, 2.0);
        trims.add(trim1);
        trims.add(trim2);
        return trims;
    }
}
