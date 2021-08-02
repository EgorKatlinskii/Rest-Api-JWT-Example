package com.example.testTask.Model;

import com.example.testTask.Enums.SensorType;
import com.example.testTask.Enums.SensorUnit;
import com.sun.istack.NotNull;
import lombok.Data;


import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Data
@Table(name = "Sensor")
public class Sensor {

    @NotNull
    @Column(name = "name")
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 15)
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "rangeFrom")
    private int rangeFrom;

    @NotNull
    @Column(name = "rangeTo")
    private int rangeTo;

    @NotNull
    @Column(name = "sensorType")
    private SensorType sensorType;

    @NotNull
    @Column(name = "sensorUnit")
    private SensorUnit sensorUnit;

    @NotNull
    @Size(max = 40)
    @Column(name = "location")
    private String location;

    @NotNull
    @Size(max = 200)
    @Column(name = "description")
    private String description;

}
