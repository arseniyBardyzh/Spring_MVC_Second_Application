package ru.bardyzh.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.bardyzh.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    public List<Person> people;

    {
        Random random = new Random();
        int age = random.nextInt(100);
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom", age, "1@1.tv"));
        people.add(new Person(++PEOPLE_COUNT,"Bill", age, "1@1.tv"));
        people.add(new Person(++PEOPLE_COUNT,"Jack", age, "1@1.tv"));
        people.add(new Person(++PEOPLE_COUNT,"Mark", age, "1@1.tv"));
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

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
