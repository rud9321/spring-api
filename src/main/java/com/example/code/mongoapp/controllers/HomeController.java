package com.example.code.mongoapp.controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.code.mongoapp.models.Student;
import com.example.code.mongoapp.repositories.IStudentRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 * 
 * 
 */
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private IStudentRepository _StudentRepo;

    public HomeController(IStudentRepository studentrepo) {
        this._StudentRepo = studentrepo;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Student GetById(@PathVariable("id") ObjectId id) {
        return this._StudentRepo.findBy_id(id);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Student> GetAll() {
        List<Student> StudentsList = this._StudentRepo.findAll();
        return StudentsList;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Student Insert(@RequestBody Student model) {
        model.set_id(ObjectId.get());
        this._StudentRepo.insert(model);
        return model;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Student Update(@PathVariable("id") ObjectId id, @Valid @RequestBody Student model) {
        model.set_id(id);
        this._StudentRepo.save(model);
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void Delete(@PathVariable ObjectId id) {
        this._StudentRepo.delete(this._StudentRepo.findBy_id(id));
    }

}