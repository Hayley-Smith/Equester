package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Breed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BreedRepository extends CrudRepository<Breed, Integer> {
}
