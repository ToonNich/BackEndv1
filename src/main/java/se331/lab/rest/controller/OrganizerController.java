package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;

import se331.lab.rest.service.EventService;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;
//    @GetMapping("organizers")
//    public ResponseEntity<?> getOrganizerList(
//            @RequestParam(value = "_limit", required = false) Integer perPage,
//            @RequestParam(value = "_page", required = false) Integer page)
//    {
//        Page<Organizer> pageOutput = organizerService.getOrganizers(perPage , page);
//        HttpHeaders responseHeader = new HttpHeaders();
//        responseHeader.set("X-total-count", String.valueOf(pageOutput.getTotalElements()));
//        return new ResponseEntity<>(pageOutput.getContent() , responseHeader,HttpStatus.OK);
//    }
@GetMapping("organizers")
public ResponseEntity<?> getOrganizers(
        @RequestParam(value = "_limit", required = false) Integer perPage,
        @RequestParam(value = "_page", required = false) Integer page) {
// Default values if parameters are null
    int pageSize = (perPage != null) ? perPage : 10; // Default to 10 if perPage is null
    int pageNumber = (page != null) ? page : 1; // Default to 1 if page is null
    Page<Organizer> pageOutput = organizerService.getOrganizers(pageSize, pageNumber);
    HttpHeaders responseHeader = new HttpHeaders();
    responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
    return new ResponseEntity<>(pageOutput.getContent(), responseHeader, HttpStatus.OK);
}
    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizer(id);
        if (output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
    @PostMapping("/organizers")
    public ResponseEntity<?> addOrganizer(@RequestBody Organizer organizer) {
        Organizer output = organizerService.save(organizer);
        return ResponseEntity.ok(output);
    }
}
