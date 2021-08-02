package com.example.testTask.Model;

import com.example.testTask.Enums.SensorType;
import com.example.testTask.Enums.SensorUnit;
import com.sun.istack.NotNull;
import lombok.Data;
import javax.validation.constraints.Size;

@Data
public class Sensor {

    @NotNull
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 15)
    private String model;

    @NotNull
    private int rangeFrom;

    @NotNull
    private int rangeTo;

    @NotNull
    private SensorType sensorType;

    @NotNull
    private SensorUnit sensorUnit;

    @NotNull
    @Size(max = 40)
    private String location;

    @NotNull
    @Size(max = 200)
    private String description;

}
