package ru.bardyzh.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.bardyzh.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    public List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Bill"));
        people.add(new Person(++PEOPLE_COUNT,"Jack"));
        people.add(new Person(++PEOPLE_COUNT,"Mark"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
