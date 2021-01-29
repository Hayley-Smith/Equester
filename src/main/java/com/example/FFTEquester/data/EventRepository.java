package com.example.FFTEquester.data;

import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.Event;
import com.example.FFTEquester.model.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event, Integer> {
    List<Event> findByEquineOrderByTimeStampDesc(Equine equine);
    List<Event> findByEquineAndEventTypeOrderByTimeStampDesc(Equine equine, EventType eventType);
    long deleteByEquine(Equine equine);
}
