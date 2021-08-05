package com.example.testTask.Model;

import com.example.testTask.Enums.SensorType;
import com.example.testTask.Enums.SensorUnit;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "sensor")
public class Sensor {

    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "name")
    @Size(max = 30)
    private String name;

    @NotNull
    @Size(max = 15)
    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "range_from")
    private int rangeFrom;

    @NotNull
    @Column(name = "range_to")
    private int rangeTo;

    @NotNull
    @Column(name = "sensor_type")
    @Enumerated(EnumType.ORDINAL)
    private SensorType sensorType;

    @NotNull
    @Column(name = "sensor_unit")
    @Enumerated(EnumType.ORDINAL)
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
