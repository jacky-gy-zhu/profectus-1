package com.profectus.interview.repository;

import com.profectus.interview.domain.entity.Tiers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TiersRepo extends CrudRepository<Tiers,Integer> {

    /**
     *  find all tiers in the database which ordered
     * @return List of Tiers which ordered by pid, which means tiers from 1 to 3
     */
    List<Tiers> findAllByOrderByTidAsc();

}
