package com.frank.controller;

import com.frank.dto.Employee;
import com.frank.dto.Student;
import com.frank.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/events/employee")
    public String sendEmployeeMessage(@RequestBody Employee employee){
        producer.send(employee);
        return "Employee message published!";
    }

    @PostMapping("/events/student")
    public String sendStudentMessage(@RequestBody Student student){
        producer.send(student);
        return "Student message published!";
    }
}