package com.ehealthcare.trackingenrolleestatus.controller;

import com.ehealthcare.trackingenrolleestatus.domain.Dependent;
import com.ehealthcare.trackingenrolleestatus.domain.Enrollee;
import com.ehealthcare.trackingenrolleestatus.exception.ResourceNotFoundException;
import com.ehealthcare.trackingenrolleestatus.service.IDependentService;
import com.ehealthcare.trackingenrolleestatus.service.IEnrolleeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enrollee")
public class EnrolleeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IEnrolleeService enrolleeService;
    @Autowired
    private IDependentService dependentService;

    @GetMapping(value = {"", "/"})
    public String index() {
        logger.info(":: Entered into index() method ::");
        return "redirect:/list";
    }

    @GetMapping(value = {"/{id}"})
    public Enrollee findById(@PathVariable Integer id) {
        logger.info(":: Entered into findById() method ::");
        return enrolleeService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollee", "id", id));
    }

    @PostMapping(value = {"/save"})
    public Enrollee save(@RequestBody Enrollee enrollee) {
        logger.info(":: Entered into save() method ::");
        return enrolleeService.save(enrollee);
    }

    @PostMapping(value = {"/update"})
    public Enrollee update(@RequestBody Enrollee enrollee) {
        logger.info(":: Entered into update() method ::");
        return enrolleeService.update(enrollee);
    }

    @GetMapping(value = {"/list"})
    public List<Enrollee> findAll() {
        logger.info(":: Entered into findAll() method ::");
        return (List<Enrollee>) enrolleeService.findAll();
    }

    @DeleteMapping(value = {"/{id}"})
    public void deleteById(@PathVariable Integer id) {
        logger.info(":: Entered into deleteById() method ::");
        enrolleeService.deleteById(id);
    }

    @DeleteMapping(value = "/all")
    public void deleteAll() {
        logger.info(":: Entered into deleteAll() method ::");
        enrolleeService.deleteAll();
    }

    @GetMapping(value = {"/dependent/{id}"})
    public Dependent findDependentById(@PathVariable Integer id) {
        logger.info(":: Entered into findDependentById() method ::");
        return dependentService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dependent", "id", id));
    }

    @PostMapping(value = {"/{enrolleeId}/dependent/save"})
    public Dependent saveDependent(@PathVariable Integer enrolleeId, @RequestBody Dependent dependent) {
        logger.info(":: Entered into saveDependent() method ::");
        Optional<Enrollee> enrollee = enrolleeService.findById(enrolleeId);
        if(enrollee.isPresent()) {
            dependent.setEnrollee(enrollee.get());
            return dependentService.save(dependent);
        } else {
           throw new ResourceNotFoundException("Enrolleee", "id", enrolleeId);
        }
    }

    @PostMapping(value = {"/{enrolleeId}/dependent/update"})
    public Dependent updateDependent(@PathVariable Integer enrolleeId, @RequestBody Dependent dependent) {
        logger.info(":: Entered into updateDependent() method ::");
        Optional<Enrollee> enrollee = enrolleeService.findById(enrolleeId);
        if(enrollee.isPresent()) {
            dependent.setEnrollee(enrollee.get());
            return dependentService.update(dependent);
        } else {
            throw new ResourceNotFoundException("Enrolleee", "id", enrolleeId);
        }
    }

    @GetMapping(value = {"/{enrolleeId}/dependent/list"})
    public List<Dependent> listDependentsByEnrolleeId(@PathVariable Integer enrolleeId) {
        logger.info(":: Entered into listDependentsByEnrolleeId() method ::");
        return (List<Dependent>) dependentService.findByEnrolleeId(enrolleeId);
    }

    @DeleteMapping(value = {"/dependent/{id}"})
    public void deleteDependentById(@PathVariable Integer id) {
        logger.info(":: Entered into deleteDependentById() method ::");
        dependentService.deleteById(id);
    }

}
