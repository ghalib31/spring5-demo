package mgn.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mgn.springframework.spring5webapp.domain.Author;
import mgn.springframework.spring5webapp.domain.Book;
import mgn.springframework.spring5webapp.domain.Publisher;
import mgn.springframework.spring5webapp.repositories.AuthorRepository;
import mgn.springframework.spring5webapp.repositories.BookRepository;
import mgn.springframework.spring5webapp.repositories.PublisherRepository;

@Component
@Slf4j
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  @Override
  public void run(final String... args) throws Exception {
    log.info("Started in bootstrap");

    Publisher publisher = new Publisher();
    publisher.setName("SFG Publishing");
    publisher.setAdressLine1("St Petersburg");
    publisher.setState("FL");
    publisherRepository.save(publisher);
    log.info("Publisher count is {}", publisherRepository.count());

    Author eric = new Author("Eric", "Evans");
    Book ddd = new Book("Domain Driven Design", "123234");
    ddd.setPublisher(publisher);
    publisher.getBooks().add(ddd);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);
    authorRepository.save(eric);
    bookRepository.save(ddd);
    publisherRepository.save(publisher);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE development without EJB", "224223232");
    noEJB.setPublisher(publisher);
    publisher.getBooks().add(noEJB);
    rod.getBooks().add(ddd);
    noEJB.getAuthors().add(rod);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
    publisherRepository.save(publisher);

    log.info("Number of books is {}", bookRepository.count());
    log.info("Publisher number of books is {}", publisher.getBooks().size());
  }
}
