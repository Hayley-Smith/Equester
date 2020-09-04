package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event, Integer> {
    Event deleteEventById(int id);
}
