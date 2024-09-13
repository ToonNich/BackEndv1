package se331.lab.rest.dao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.OrganizerRepository;
@Repository
@RequiredArgsConstructor
@Profile("db")
public class OrganizerDaoDbImpl implements OrganizerDao {
    final OrganizerRepository organizerRepository;
    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(organizerRepository.count());
    }
    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        int pageNumber = (page != null) ? page - 1 : 0;  // Default to page 0 if null
        int size = (pageSize != null) ? pageSize : 10;   // Default to pageSize 10 if null
        return organizerRepository.findAll(PageRequest.of(pageNumber, size));
    }
//    @Override
//    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
//        return organizerRepository.findAll(PageRequest.of(page - 1 , pageSize));
//    }
    @Override
    public Organizer getOrganizer(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }
    @Override
    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}
