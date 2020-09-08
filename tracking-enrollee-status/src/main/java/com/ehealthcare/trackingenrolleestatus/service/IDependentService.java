package com.ehealthcare.trackingenrolleestatus.service;

import com.ehealthcare.trackingenrolleestatus.domain.Dependent;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IDependentService {

    Dependent save(Dependent depedent);

    Optional<Dependent> findById(Integer id);

    Dependent update(Dependent depedent);

    Iterable<Dependent> findAll();

    void deleteById(Integer id);

    void delete(Dependent depedent);

    void deleteAll();

    List<Dependent> findByEnrolleeId(Integer enrolleeId);

}
