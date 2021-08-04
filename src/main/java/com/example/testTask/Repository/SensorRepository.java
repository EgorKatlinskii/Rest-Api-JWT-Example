package com.example.testTask.Repository;

import com.example.testTask.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor,Integer> {


    List<Sensor> findBySensorsUnitContainingIn(String text);
}
