package se331.lab.rest.dao;

import se331.lab.rest.entity.Organizer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrganizerDao {

    Organizer save(Organizer organizer);
    Integer getOrganizerSize();
    Page<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
