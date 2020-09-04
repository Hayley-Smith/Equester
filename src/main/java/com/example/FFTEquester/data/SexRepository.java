package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SexRepository extends CrudRepository<Sex, Integer> {
}
