package com.example.testTask.Repository;

import com.example.testTask.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SensorRepository extends JpaRepository<Sensor,Integer> {


   /* List<Sensor> findBySensorsUnitContainingIn(String text);*/
}
