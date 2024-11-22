package sg.nus.edu.iss.vttp_5a_ssf_day15l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.edu.iss.vttp_5a_ssf_day15l.model.Person;
import sg.nus.edu.iss.vttp_5a_ssf_day15l.repo.ListRepo;

@Service
public class PersonService {
    @Autowired
    ListRepo personRepo;

    public void addPerson(String redisKey, Person person){
        personRepo.rightPush(redisKey, person.toString());
    }

    public List<Person> findAll(String redisKey){
        System.out.println("fndAll in Service Called");
        List<Object> listData = personRepo.getList(redisKey);
        List<Person> persons = new ArrayList<>();

        for(Object data: listData) {
            String [] rawData = data.toString().split(",");
            Person p = new Person(Integer.parseInt(rawData[0]), rawData[1], rawData[2]);
            persons.add(p);

        }
        return persons;
    }

    public boolean delete(String redisKey, Person person){
        return personRepo.deleteItem(null, person.toString());
    }
}
