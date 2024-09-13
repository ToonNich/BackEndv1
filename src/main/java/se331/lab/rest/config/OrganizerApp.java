package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class OrganizerApp implements ApplicationListener<ApplicationReadyEvent> {
    final OrganizerRepository organizerRepository;
    @Override
    public void onApplicationEvent (ApplicationReadyEvent applicationReadyEvent) {
        organizerRepository.save(Organizer.builder()
                .id(112233L)
                .organizationName("ABC")
                .address("Chiangmai")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(445566L)
                .organizationName("DEF")
                .address("Bangkok")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(778899L)
                .organizationName("GHI")
                .address("Pattaya")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(100001L)
                .organizationName("JKL")
                .address("Chiangrai")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(100001L)
                .organizationName("MNO")
                .address("Chiangmai")
                .build());
        organizerRepository.save(Organizer.builder()
                .id(100001L)
                .organizationName("PQR")
                .address("Bangkok")
                .build());
    }
}
