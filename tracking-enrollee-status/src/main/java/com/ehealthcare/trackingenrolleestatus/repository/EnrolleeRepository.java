package com.ehealthcare.trackingenrolleestatus.repository;

import com.ehealthcare.trackingenrolleestatus.domain.Enrollee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolleeRepository extends CrudRepository<Enrollee, Integer> {
}
