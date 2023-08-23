package com.sherwin.paintassessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private List<Wall> walls;
    //Assume room had one or more doors
    private List<Door> doors;
    private List<Window> windows;
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


