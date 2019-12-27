import be.ben.tinkin.Fact;
import be.ben.tinkin.provider.FileFactProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Benoit Dupont
 */
class FileFactProviderTest {

    private static Path FACTS_FILE_PATH;

    @Test
    void theFactFileShouldContainsTheMalazonEmpireBook() throws IOException {
        FileFactProvider factProvider = new FileFactProvider(FACTS_FILE_PATH);

        assertThat(factProvider.getFacts())
                .extracting(Fact::getText)
                .contains("The Malazan empire by Steven Erikson");
    }

    @BeforeAll
    static void beforeAll() throws URISyntaxException {
        URL resource = FileFactProviderTest.class.getClassLoader().getResource("facts.txt");
        assertThat(resource).isNotNull();
        URI uri = resource.toURI();

        FACTS_FILE_PATH = Paths.get(uri);
    }
}