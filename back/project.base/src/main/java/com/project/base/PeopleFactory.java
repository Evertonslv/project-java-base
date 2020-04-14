package com.project.base;

public class PeopleFactory {

    public static People of(PeopleDto peopleDto) {
        People people = People.builder()
                .id(peopleDto.getId())
                .name(peopleDto.getName())
                .email(peopleDto.getEmail())
                .password(peopleDto.getPassword()).build();
        return people;
    }

    public static People of(PeopleFilter peopleFilter) {
        People people = People.builder()
                .name(peopleFilter.getName())
                .email(peopleFilter.getEmail())
                .password(peopleFilter.getPassword()).build();
        return people;
    }
}