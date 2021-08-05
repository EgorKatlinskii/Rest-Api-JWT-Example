package com.example.testTask.Controller;

import com.example.testTask.Model.Sensor;
import com.example.testTask.Service.SensorServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/sensors")
public class SensorController {

    SensorServiceImpl sensorService;


    @PostMapping("/addSensor")
    @ResponseBody
    public ResponseEntity<?> createSensor(@RequestBody Sensor sensor){
        return sensorService.addSensor(sensor) !=null
                ? (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<Sensor>> getAll() {
        List<Sensor> sensors = sensorService.getAllSensors();
        return sensors != null && !sensors.isEmpty()
                ? ResponseEntity.status(HttpStatus.OK).body(sensors)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/editSensor/sensor")
    @ResponseBody
    public ResponseEntity<?> editSensor(@RequestBody Sensor sensor) {
        return sensorService.editSensor(sensor,sensor.getId())
                ? (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping("/deleteSennor/{id}")
    @ResponseBody
    public ResponseEntity<?> deleteSensor(@PathVariable int id){
        return sensorService.deleteSensor(id)
                ? (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

