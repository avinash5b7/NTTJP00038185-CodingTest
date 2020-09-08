package com.ehealthcare.trackingenrolleestatus.repository;

import com.ehealthcare.trackingenrolleestatus.domain.Dependent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DependentRepository extends CrudRepository<Dependent, Integer> {

    @Query("from Dependent d where d.enrollee.id = :enrolleeId")
    List<Dependent> findByEnrolleeId(@Param("enrolleeId") Integer enrolleeId);
}
