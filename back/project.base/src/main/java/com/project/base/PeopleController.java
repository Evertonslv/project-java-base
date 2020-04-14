package com.project.base;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@NoArgsConstructor
@RestController
public class PeopleController {

    private PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/people/save", method =  RequestMethod.POST)
    public ResponseEntity<People> savePeople(@Valid @RequestBody PeopleDto peopleDto) {
        log.info("teste");
        People people = peopleService.save(peopleDto);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @RequestMapping(value = "/people", method =  RequestMethod.POST)
    public ResponseEntity<List<People>> getPeople(@Valid @RequestBody PeopleFilter peopleFilter) {
        log.info("teste");
        List<People> peopleList = peopleService.getPeople(peopleFilter);
        return new ResponseEntity<>(peopleList, HttpStatus.OK);
    }

    @RequestMapping(value = "/people/{id}", method =  RequestMethod.GET)
    public ResponseEntity<People> getPeopleById(@PathVariable(value = "id") Integer id) {
        log.info("teste");
        Optional<People> people = peopleService.getPeopleById(id);
        return new ResponseEntity<>(people.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/people", method =  RequestMethod.PUT)
    public ResponseEntity<Object> updatePeople(@Valid @RequestBody PeopleDto peopleDto) {
        log.info("teste");
        People people = peopleService.updatePeople(peopleDto);

        if(people != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/people/{id}", method =  RequestMethod.DELETE)
    public ResponseEntity<Object> deletePeolpe(@PathVariable(name = "id") Integer id) {
        log.info("teste");
        peopleService.deletePeople(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
