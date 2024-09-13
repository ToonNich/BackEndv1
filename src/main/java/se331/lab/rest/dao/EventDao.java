package se331.lab.rest.dao;

import se331.lab.rest.entity.Event;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
}
