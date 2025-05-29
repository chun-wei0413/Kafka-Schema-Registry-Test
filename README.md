# Kafka Multi-Schema Consumer

This repository contains an example of consuming messages with different schemas from the same Kafka topic using Spring Boot and Apache Avro.

## Overview

In this example, we demonstrate how to send and consume messages of different schemas (e.g., `Employee` and `Student`) to the same Kafka topic. The consumer is designed to handle multiple types of messages by checking the payload type and processing accordingly.

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Docker & Docker Compose
- Java 17+
- Maven

---

## 🐳 Run with Docker Compose

To spin up the Kafka environment including Zookeeper, Kafka broker, Schema Registry, and Control Center, run:

```bash
docker compose up -d
```

Once the services are running, you will have:

Zookeeper on localhost:2181

Kafka broker on localhost:9092

Schema Registry on http://localhost:8081

Kafka Control Center on http://localhost:9021

🎯 API Endpoints
Your Spring Boot application exposes two endpoints to publish Avro messages to Kafka.

1️⃣ Send Employee Message

Endpoint:

POST /events/employee

Request Body:
```
{
    "id": "409262671",
    "firstName": "Russell",
    "lastName": "Li",
    "email": "frank.com",
    "dob": "13/04/91",
    "age": 20
}
```
2️⃣ Send Student Message

Endpoint:

POST /events/student

Request Body:
```
{
    "id": "456",
    "name": "Frank",
    "grade": "20"
}
```