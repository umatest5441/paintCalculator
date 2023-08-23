package com.sherwin.paintassessment.utils;

import com.sherwin.paintassessment.BasePaintingAreaCalculatorTest;
import static org.junit.Assert.*;

import com.sherwin.paintassessment.models.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RoomValidatorTest extends BasePaintingAreaCalculatorTest {

    @InjectMocks
    private RoomValidator roomValidator;
    @Test
    public void validateRoomHasWallsAndDoorsAndWindows(){
        List<String> errors=new ArrayList<>();
        roomValidator.validate(getRoomWithOutTrims(),errors);
        assertFalse(errors.isEmpty());
        assertEquals("Room should have Trims",errors.get(0));
    }
    @Test
    public void validateRoomHasWallsAndDoors(){
        List<String> errors=new ArrayList<>();
        roomValidator.validate(getRoomWithOutWindowsAndTrims(),errors);
        assertEquals(2,errors.size());
        assertEquals("Room should have Windows",errors.get(0));
        assertEquals("Room should have Trims",errors.get(1));
    }
    @Test
    public void validateRoomHasWallsAndDoorsAndWindowsAndTrims(){
        List<String> errors=new ArrayList<>();
        roomValidator.validate(getRoom(),errors);
        assertEquals(0,errors.size());
    }
    @Test
    public void validateLengthAndHeight(){
        List<String> errors=new ArrayList<>();
        Room room=getRoom();
        room.getDoors().get(0).setLength(0);
        roomValidator.validate(room,errors);
        assertEquals(1,errors.size());
        assertEquals("door length must be greater than 0.",errors.get(0));
    }

    @Test
    public void validateRoomNotHasWallsAndDoorsAndWindowsAndTrims(){
        List<String> errors=new ArrayList<>();
        roomValidator.validate(new Room(),errors);
        assertEquals(4,errors.size());
        assertEquals("Room should have walls",errors.get(0));
        assertEquals("Room should have Door",errors.get(1));
        assertEquals("Room should have Windows",errors.get(2));
        assertEquals("Room should have Trims",errors.get(3));
    }
}
