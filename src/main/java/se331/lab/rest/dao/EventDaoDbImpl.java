package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.repository.EventRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class EventDaoDbImpl implements EventDao{
    final EventRepository eventRepository;

    @Override
    public Integer getEventSize() {
        return Math.toIntExact(eventRepository.count());
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        int pageNumber = (page != null) ? page - 1 : 0;  // Default to page 0 if null
        int size = (pageSize != null) ? pageSize : 10;   // Default to pageSize 10 if null
        return eventRepository.findAll(PageRequest.of(pageNumber, size));
    }

    @Override
    public Event getEvent(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }
}
