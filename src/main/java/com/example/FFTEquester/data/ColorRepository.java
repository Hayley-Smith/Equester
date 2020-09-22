package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ColorRepository extends CrudRepository<Color, Integer>{
}
