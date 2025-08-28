package de.gfn.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class PersonenController {

    private List<Person> personen;

    public PersonenController() {
        personen = new ArrayList<>();
        personen.add(new Person("Peter", "Parker"));
        personen.add(new Person("Carol", "Danvers"));
        personen.add(new Person("Bruce", "Banner"));
        personen.add(new Person("Natasha", "Romanov"));
    }

    // http://localhost:8080/api/v1/all
    @GetMapping("/all")
    public List<Person> getAll() {
        return personen;
    }

    // http://localhost:8080/api/v1/all/sorted
    @GetMapping("/all/sorted")
    public List<Person> getAllSorted() {
        Collections.sort(personen);
        return personen;
    }

    @GetMapping("/selected")
    public List<Person> getSelected(@RequestParam String start) {
        return personen.stream()
                        .filter(p -> p.getVorname().startsWith(start))
                        .collect(Collectors.toList());
    }
}