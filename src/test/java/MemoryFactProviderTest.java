import be.ben.tinkin.Fact;
import be.ben.tinkin.provider.FactProvider;
import be.ben.tinkin.provider.FileFactProvider;
import be.ben.tinkin.provider.MemoryFactProvider;
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
class MemoryFactProviderTest {
    @Test
    void theFactMemoryShouldContainsTheMalazonEmpireBook() {
        FactProvider factProvider = new MemoryFactProvider();

        assertThat(factProvider.getFacts())
                .extracting(Fact::getText)
                .contains("The witcher");
    }
}