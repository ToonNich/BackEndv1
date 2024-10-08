package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("manual")
public class OrganizerImpl implements OrganizerDao{
    List<Organizer> organizerList;

    @PostConstruct
    public void init() {
        organizerList = new ArrayList<>();
        organizerList.add(Organizer.builder()
                .id(112233L)
                .organizationName("ABC")
                .address("Chiangmai")
                .build());
        organizerList.add(Organizer.builder()
                .id(445566L)
                .organizationName("DEF")
                .address("Bangkok")
                .build());
        organizerList.add(Organizer.builder()
                .id(778899L)
                .organizationName("GHI")
                .address("Pattaya")
                .build());
        organizerList.add(Organizer.builder()
                .id(100001L)
                .organizationName("JKL")
                .address("Chiangrai")
                .build());
        organizerList.add(Organizer.builder()
                .id(100001L)
                .organizationName("MNO")
                .address("Chiangmai")
                .build());
        organizerList.add(Organizer.builder()
                .id(100001L)
                .organizationName("PQR")
                .address("Bangkok")
                .build());
    }
    @Override
    public Integer getOrganizerSize(){
        return organizerList.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page){
        pageSize = pageSize == null ? organizerList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page-1) * pageSize;
        return new PageImpl<Organizer>(organizerList.subList(firstIndex,firstIndex + pageSize) , PageRequest.of(page,pageSize),organizerList.size());
    }

    @Override
    public Organizer getOrganizer(Long id){
        return organizerList.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public Organizer save(Organizer organizer) {
        organizer.setId(organizerList.get(organizerList.size()-1).getId()+1);
        organizerList.add(organizer);
        return organizer;
    }
}
