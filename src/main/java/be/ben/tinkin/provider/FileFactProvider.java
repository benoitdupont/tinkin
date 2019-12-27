package be.ben.tinkin.provider;

import be.ben.tinkin.Fact;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Loads facts from a file
 *
 * @author Benoit Dupont
 */
public class FileFactProvider implements FactProvider {

    private final Path filePath;

    public FileFactProvider(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Fact> getFacts() {
        try (Stream<String> lines = Files.lines(filePath)){
            return lines
                    .map(Fact::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
