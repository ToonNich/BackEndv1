package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("manual")
public class EventDaolmpl implements EventDao{
    List<Event> eventList;

    @PostConstruct
    public void init() {
        eventList = new ArrayList<>();
        eventList.add(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .organizer("CAMT")
                .build());
        eventList.add(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00 am-1.00 pm.")
                .petsAllowed(false)
                .organizer("CMU")
                .build());
        eventList.add(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00 - 10.00 pm.")
                .petsAllowed(false)
                .organizer("Chaing Mai")
                .build());
        eventList.add(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's play Water")
                .location("Chiang Mai Moat")
                .date("13th Aprill")
                .time("10.00 am - 6.00 pm.")
                .petsAllowed(false)
                .organizer("Chiang MAi Municipality")
                .build());
    }

    @Override
    public Integer getEventSize(){
        return eventList.size();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page){
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Event>(eventList.subList(firstIndex, firstIndex+pageSize), PageRequest.of(page, pageSize), eventList.size());
    }

    @Override
    public Event getEvent(Long id){
        return eventList.stream().filter(event ->
        event.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Event save(Event event) {
        event.setId(eventList.get(eventList.size()-1).getId()+1);
        eventList.add(event);
        return event;
    }
}
