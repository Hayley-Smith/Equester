package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Equine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EquineRepository extends CrudRepository<Equine, Integer> {
   Equine findById(int id);
   List<Equine> findEquineByUser(String user);
}

