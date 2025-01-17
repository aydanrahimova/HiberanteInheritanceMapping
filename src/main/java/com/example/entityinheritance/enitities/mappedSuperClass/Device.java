package com.example.entityinheritance.enitities.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

//When we use mappedSupperClass method,in that case the parent class is not entity-that means we have only tables of subclasses

@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Device {
    @Id
    Long id;
    String brand;
    String model;
    double price;
}

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
class Computer extends Device {
    String processor;
    int ram; // in GB
}

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
class Mobile extends Device {
    String os; // e.g., Android, iOS
    int batteryLife; // in hours
}
