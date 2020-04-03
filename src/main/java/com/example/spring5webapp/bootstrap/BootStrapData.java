package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.domain.Author;
import com.example.spring5webapp.domain.Book;
import com.example.spring5webapp.domain.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher geethapress= new Publisher("geethapress","autonagar","Vijayawada","AP","534111");
        publisherRepository.save(geethapress);

        System.out.println("no of publishers "+publisherRepository.count());
        Author eric= new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublishers(geethapress);
        geethapress.getBooks().add(ddd);
        authorRepository.save(eric);
         bookRepository.save(ddd);
         publisherRepository.save(geethapress);

         Author rod=new Author("Rod","Johnson");
         Book noEJB= new Book("J2EE Development without EJB","12341234");
         rod.getBooks().add(noEJB);
         noEJB.getAuthors().add(rod);
         noEJB.setPublishers(geethapress);
         geethapress.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(geethapress);
         System.out.println("Started in bootstrap");
         System.out.println("Number of books"+bookRepository.count());
         System.out.println("Publisher no.of books"+geethapress.getBooks().size());
    }
}
