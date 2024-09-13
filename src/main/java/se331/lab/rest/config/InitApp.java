package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.repository.EventRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    @Override
    public void onApplicationEvent (ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd SEPT")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .organizer("CAMT").build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th JAN")
                .time("8.00 am-4.00 pm.")
                .petsAllowed(false)
                .organizer("CMU").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th NOV")
                .time("10.00-6.00 pm.")
                .petsAllowed(false)
                .organizer("Chiang mai").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkarn")
                .description("Let's play water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00-6.00 pm.")
                .petsAllowed(false)
                .organizer("Chiang Mai Municipality").build());
    }
}
