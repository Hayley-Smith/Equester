package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface TypeRepository extends CrudRepository<Type, Integer> {
}
