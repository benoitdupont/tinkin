import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Playing with {@link Path} api and resources
 *
 * @author Benoit Dupont
 */
@Disabled("to avoid ruining the CI")
class PathSmokeTest {

    /**
     * Path cannot access src/test/resources
     */
    @Test
    void path_via_simple_file_name() {
        Path path = Path.of("facts.txt");
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * Path cannot access src/test/resources
     */
    @Test
    void path_via_simple_file_name_at_root() {
        Path path = Path.of("/facts.txt");
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * Path cannot access src/test/resources
     */
    @Test
    void path_via_simple_file_name_at_current_directory() {
        Path path = Path.of("./facts.txt");
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * If explicitly set, it access src/test/resources from .
     */
    @Test
    void path_with_src_test_resource_in_path() {
        Path path = Path.of("src/test/resources", "facts.txt");
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * In order to access src/test/resources content, you need to get them from the classloader, which put them into .
     */
    @Test
    void path_from_classloader() throws URISyntaxException {
        URL resource = PathSmokeTest.class.getClassLoader().getResource("facts.txt");
        Path path = Path.of(resource.toURI());
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * Works, TODO see the difference with PathSmokeTest.class.getClassLoader().getResource(
     */
    @Test
    void path_from_class_getResource() throws URISyntaxException {
        URL resource = PathSmokeTest.class.getResource("facts.txt");
        Path path = Path.of(resource.toURI());
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * Works also via {@link ClassLoader#getSystemResource(String)}
     */
    @Test
    void path_from_classloader_getSystemResource() throws URISyntaxException {
        URL resource = ClassLoader.getSystemResource("facts.txt");
        Path path = Path.of(resource.toURI());
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * Works also via {@link Thread#currentThread()#getContextClassLoader()}
     */
    @Test
    void path_from_thread_context_classloader() throws URISyntaxException {
        URL resource = Thread.currentThread().getContextClassLoader().getResource("facts.txt");
        Path path = Path.of(resource.toURI());
        assertThat(path.toFile().exists()).isTrue();
    }

    /**
     * I love Spring
     */
    @Test
    void path_from_spring_ClassPathResource() throws IOException {
        ClassPathResource resource = new ClassPathResource("facts.txt");
        Path path = Path.of(resource.getURI());
        assertThat(path.toFile().exists()).isTrue();
    }
}