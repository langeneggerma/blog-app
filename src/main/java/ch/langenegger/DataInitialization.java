package ch.langenegger;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataInitialization {

    @Transactional
    public void init(@Observes StartupEvent event) {

        BlogRepository blogRepository = new BlogRepository();

        blogRepository.persist(new Blog("Testing Blog", "This is my testing blog"));
        blogRepository.persist(new Blog("Testing Blog 2", "This is my testing blog 2"));
    }
}