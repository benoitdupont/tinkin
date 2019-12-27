package be.ben.tinkin.provider;

import be.ben.tinkin.Fact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Loads facts from memory: hardcoded constants
 *
 * @author Benoit Dupont
 */
public class MemoryFactProvider implements FactProvider {

    private static final List<Fact> FACTS = Arrays.asList(new Fact("The witcher", "pc game"));

    public MemoryFactProvider() {
    }

    @Override
    public List<Fact> getFacts() {
        return FACTS;
    }
}
