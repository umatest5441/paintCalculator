package com.sherwin.paintassessment.services;

import com.sherwin.paintassessment.models.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PaintingAreaCalculatorServiceTest {
    @InjectMocks
    private PaintingAreaCalculatorService paintingAreaCalculatorService;


    @Test
    public void calculatePaintableAreaFourWallsOneWindowOneDoorAndTrimsTest() {
        Room room = getRoom();
        double area = paintingAreaCalculatorService.calculatePaintableArea(room);
        Assert.assertTrue(Double.compare(594.6, area) == 0);
    }

    @Test
    public void calculatePaintableAreaFourWallsOneWindowOneDoorTest() {
        Room room = getRoomWithOutTrims();
        double area = paintingAreaCalculatorService.calculatePaintableArea(room);
        Assert.assertTrue(Double.compare(595, area) == 0);
    }
    @Test
    public void calculatePaintableAreaFourWallsOneDoorTest() {
        Room room = getRoomWithOutWindowsAndTrims();
        double area = paintingAreaCalculatorService.calculatePaintableArea(room);
        Assert.assertTrue(Double.compare(604.0, area) == 0);
    }

    private Room getRoomWithOutWindowsAndTrims() {
        Room room = new Room();
        room.setWalls(getWalls());
        room.setDoors(getDoors());
        return room;
    }

    private Room getRoomWithOutTrims() {
        Room room = new Room();
        room.setWalls(getWalls());
        room.setDoors(getDoors());
        room.setWindows(getWindows());
        return room;
    }

    private Room getRoom() {
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
