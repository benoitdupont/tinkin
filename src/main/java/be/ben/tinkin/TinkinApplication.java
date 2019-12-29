package be.ben.tinkin;

import be.ben.tinkin.provider.FactProvider;
import be.ben.tinkin.provider.FileFactProvider;
import be.ben.tinkin.provider.MemoryFactProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Loads {@link Fact} from somewhere
 *
 * @author Benoit Dupont
 */
@SpringBootApplication
public class TinkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinkinApplication.class);
    }

    @Bean
    FactProvider fileFactProvider() throws IOException {
        return new FileFactProvider(Path.of(new ClassPathResource("facts.txt").getURI()));
    }

    @Bean
    FactProvider memoryFactProvider() {
        return new MemoryFactProvider();
    }

    // Yes you can insert several implementation of the same interface via a varargs ! Well played Spring
    @Bean
    String factDisplayer(FactProvider... factProviders) {
        for (FactProvider factProvider : factProviders) {
            factProvider.getFacts()
                    .forEach(System.out::println);
        }

        return ""; // wonderful
    }
}
