package com.example.testTask.Service;

import com.example.testTask.IService.SensorService;
import com.example.testTask.Model.Sensor;
import com.example.testTask.Repository.SensorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SensorServiceImpl implements SensorService {

    SensorRepository sensorRepository;
    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public Sensor addSensor(Sensor sensor)  {
        sensorRepository.save(sensor);
        log.info("Create new sensor - {}",sensor);
        return sensor;
    }

    @Override
    public List<Sensor> getAllSensors()  {

        List<Sensor> sensors = sensorRepository.findAll();
        System.out.println("!!!");
        log.info("Sensor received - {}", sensors.size());
        return sensors;
    }

  /*  public List<Sensor> fingBySensorsByText(String text) {
        List<Sensor> searchSensor = sensorRepository.findBySensorsUnitContainingIn(text);
        log.info("!!!!");
        return searchSensor;
    }*/

    @Override
    public boolean editSensor(Sensor editSensor,int id) {
        if(sensorRepository.existsById(id)){
            editSensor.setId(id);
            sensorRepository.save(editSensor);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSensor(int id) {
        if(sensorRepository.existsById(id)){
            sensorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
