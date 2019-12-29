package be.ben.tinkin.provider;

import be.ben.tinkin.Fact;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads facts from memory: hardcoded constants
 *
 * @author Benoit Dupont
 */
public class MemoryFactProvider implements FactProvider {

    private static final List<Fact> facts = new ArrayList<>();

    public MemoryFactProvider() {
        facts.add(new Fact("The Witcher", "pc game"));
        facts.add(new Fact("Redshirts", "book"));
    }

    @Override
    public List<Fact> getFacts() {
        return facts;
    }

    @Override
    public Fact getFactByName(String name) {

        // TODO Several issues here:
        // findAny
        // Optional to null is maybe not the best thing to do
        return facts.stream()
                .filter(f -> f.getText().equals(name))
                .findAny()
                .orElse(null);
    }

    @Override
    public void createFact(String name, String category) {
        facts.add(new Fact(name, category));
    }

    @Override
    public boolean deleteFact(String name) {
        for (Fact fact : facts) {
            if (fact.getText().equals(name)) {
                facts.remove(fact);
                return true;
            }
        }
        return false;
    }
}
