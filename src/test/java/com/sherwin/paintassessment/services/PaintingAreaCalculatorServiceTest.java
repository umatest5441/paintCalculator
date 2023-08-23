package com.sherwin.paintassessment.services;

import com.sherwin.paintassessment.BasePaintingAreaCalculatorTest;
import com.sherwin.paintassessment.models.Room;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaintingAreaCalculatorServiceTest extends BasePaintingAreaCalculatorTest {
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


}
