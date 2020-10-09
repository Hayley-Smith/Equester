package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EquineRepository extends CrudRepository<Equine, Integer> {
   Optional<Equine> findById(Integer id);
   List<Equine> findByUser(User user);


}

