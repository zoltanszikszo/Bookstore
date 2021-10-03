package zoltanszikszo.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zoltanszikszo.Bookstore.domain.Book;
import zoltanszikszo.Bookstore.domain.BookRepository;
import zoltanszikszo.Bookstore.domain.Category;
import zoltanszikszo.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		return args ->  {
			System.out.println("Adding some category to our list");
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Crime"));
			crepository.save(new Category("Drama"));
			crepository.save(new Category("Action"));

			System.out.println("Adding some books to the database");

			repository.save(new Book("A Farewell to Arms",  "Ernest Hemingway", 1929, "1232323-21", 9.99, crepository.findCategoryByName("Romance").get(0)));

			System.out.println("fetch all books");
			for(Book book: repository.findAll()){
				System.out.println(book.toString());
			}
		};
	}

}
