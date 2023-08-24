package com.sherwin.paintassessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Valid
    @NotEmpty(message = " Wall value should not be null")
    private List<Wall> walls;
    //Assume room had one or more doors
    @Valid
    @NotEmpty(message = " Door value should not be null")
    private List<Door> doors;
    @Valid
    @NotEmpty(message = " Window value should not be null")
    private List<Window> windows;
    @Valid
    @NotEmpty(message = " Trim value should not be null")
    private List<Trim> trims;

    public List<Wall> getWalls() {
        return this.walls == null ? new ArrayList<>() : walls;
    }

    public List<Door> getDoors() {
        return this.doors == null ? new ArrayList<>() : doors;
    }

    public List<Trim> getTrims() {
        return this.trims == null ? new ArrayList<>() : trims;
    }

    public List<Window> getWindows() {
        return this.windows == null ? new ArrayList<>() : windows;
    }

}

