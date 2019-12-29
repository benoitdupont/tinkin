package be.ben.tinkin.service;

import be.ben.tinkin.Fact;
import be.ben.tinkin.provider.FactProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Benoit Dupont
 */
@RestController
public class FactController {
    @Autowired
    @Qualifier("memoryFactProvider")
    private FactProvider factProvider;

    // TODO get all facts ? /rest/fact + no params ? /rest/facts ?

    @GetMapping("/rest/fact/{name}")
    public ResponseEntity<Fact> getFact(@PathVariable("name") String name) {
        Fact fact = factProvider.getFactByName(name);

        if (fact == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(fact);
    }

    @PostMapping("/rest/fact")
    public ResponseEntity<Void> postFact(@RequestParam("name") String name, @RequestParam("category") String category) {

        factProvider.createFact(name, category);

        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/rest/fact/{name}")
    public ResponseEntity<Void> deleteFact(@PathVariable("name") String name) {
        boolean deleted = factProvider.deleteFact(name);

        if(deleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
