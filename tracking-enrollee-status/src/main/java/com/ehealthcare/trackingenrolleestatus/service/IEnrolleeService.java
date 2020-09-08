package com.ehealthcare.trackingenrolleestatus.service;

import com.ehealthcare.trackingenrolleestatus.domain.Enrollee;

import java.util.Optional;

public interface IEnrolleeService {

    Enrollee save(Enrollee enrollee);

    Optional<Enrollee> findById(Integer id);

    Enrollee update(Enrollee enrollee);

    Iterable<Enrollee> findAll();

    void deleteById(Integer id);

    void delete(Enrollee enrollee);

    void deleteAll();
}
