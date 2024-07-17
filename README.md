# Kafka Multi-Schema Consumer

This repository contains an example of consuming messages with different schemas from the same Kafka topic using Spring Boot and Apache Avro.

## Overview

In this example, we demonstrate how to send and consume messages of different schemas (e.g., `Employee` and `Student`) to the same Kafka topic. The consumer is designed to handle multiple types of messages by checking the payload type and processing accordingly.