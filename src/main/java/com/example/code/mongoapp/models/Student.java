package com.example.code.mongoapp.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Student
 */
@Document(collection = "Students")
public class Student {

    @Id
    private ObjectId _id;

    private String first_name;
    private String last_name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int age;
    private String address;

    public Student(String first_name, String last_name, int age, String address) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.address = address;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _Id) {
        this._id = _Id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}