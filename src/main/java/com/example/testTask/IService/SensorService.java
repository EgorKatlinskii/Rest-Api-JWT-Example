package com.example.testTask.IService;

import com.example.testTask.Model.Sensor;

import java.util.List;

public interface SensorService {

    Sensor addSensor(Sensor sensor) ;

    List<Sensor> getAllSensors() ;

  /*  List<Sensor> fingBySensorsByText(String name);*/

    boolean editSensor(Sensor sensor,int id);

    boolean deleteSensor(int id);

}
