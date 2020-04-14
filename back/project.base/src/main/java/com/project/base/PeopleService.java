package com.project.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People save(PeopleDto peopleDto) {
        return peopleRepository.save(PeopleFactory.of(peopleDto));
    }

    public List<People> getPeople(PeopleFilter peopleFilter) {
        Example<People> peopleExample = Example.of(PeopleFactory.of(peopleFilter), ExampleMatcher.matchingAll());
        return peopleRepository.findAll(peopleExample);
    }

    public Optional<People> getPeopleById(Integer id) {
        return peopleRepository.findById(id);
    }

    public void deletePeople(Integer id) {
        peopleRepository.deleteById(id);
    }

    public People updatePeople(PeopleDto peopleDto) {
        return peopleRepository.save(PeopleFactory.of(peopleDto));
    }

}
