package com.frank.consumer;

import com.frank.dto.Employee;
import com.frank.dto.Message;
import com.frank.dto.Student;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void consume(Message message) {
        Object payload = message.getPayload();
        if (payload instanceof Employee) {
            Employee employee = (Employee) payload;
            System.out.println("Received Employee message: " + employee);
        } else if (payload instanceof Student) {
            Student student = (Student) payload;
            System.out.println("Received Student message: " + student);
        } else {
            System.out.println("Received unknown message type");
        }
    }
}