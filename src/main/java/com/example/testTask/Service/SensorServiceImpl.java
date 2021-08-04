package com.example.testTask.Service;

import com.example.testTask.IService.SensorService;
import com.example.testTask.Model.Sensor;
import com.example.testTask.Repository.SensorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SensorServiceImpl implements SensorService {

    SensorRepository sensorRepository;

    @Override
    public List<Sensor> getAllSensors() {
        final List<Sensor> sensors = sensorRepository.findAll();
        log.info("Users received - {}", sensors.size());
        return sensors;
    }

    public List<Sensor> fingBySensorsByText(String text) {
        List<Sensor> searchSensor = sensorRepository.findBySensorsUnitContainingIn(text);
        log.info("!!!!");
        return searchSensor;
    }

    @Override
    public Sensor editSensor(Sensor sensor) {
        return null;
    }

    @Override
    public void deleteSensor() {

    }
}
