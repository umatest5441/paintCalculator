package com.sherwin.paintassessment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherwin.paintassessment.BasePaintingAreaCalculatorTest;
import com.sherwin.paintassessment.models.Room;
import com.sherwin.paintassessment.services.PaintingAreaCalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class PaintingAreaCalculatorControllerTest extends BasePaintingAreaCalculatorTest {
    private MockMvc mockMvc;

    @InjectMocks
    private PaintingAreaCalculatorController paintingAreaCalculatorController;


    @Mock
    PaintingAreaCalculatorService paintingAreaCalculatorService;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(paintingAreaCalculatorController).build();
    }

    @Test
    public void calculatePaintingAreaTest() throws Exception {
        Room room = getRoom();
        when(paintingAreaCalculatorService.calculatePaintableArea(any(Room.class))).thenReturn(594.6);
        mockMvc.perform(post("/paint/calculate/room")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(room)))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"area\":594.6}"));
    }

    // Helper method to convert objects to JSON
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
