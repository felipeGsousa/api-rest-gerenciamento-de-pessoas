package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<?> createPerson(@RequestBody PersonDTO personDTO){

        Person personToSave = personDTO.dtoToPerson();

        personRepository.save(personToSave);

        return new ResponseEntity<>(personToSave, HttpStatus.CREATED);
    }

    public List<Person> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().collect(Collectors.toList());
    }

    public ResponseEntity<?> findById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) return new ResponseEntity<>(person.get(), HttpStatus.OK);
        return new ResponseEntity<>("Pessoa não encontrada", HttpStatus.NOT_FOUND);
    }
}
