package ru.bardyzh.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.bardyzh.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    public List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(1,"Tom"));
        people.add(new Person(2,"Bill"));
        people.add(new Person(3,"Jack"));
        people.add(new Person(4,"Mark"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
