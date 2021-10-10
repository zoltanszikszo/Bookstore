package zoltanszikszo.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zoltanszikszo.Bookstore.domain.*;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository userRepository) {
		return args ->  {

			System.out.println("Adding test users to our application");
			User user1 = new User("user", "$2a$10$t8geXOnEiFq7BjLxuqdlQuVtkZmnz2h29JLQvdRe1o5QwKi81I7Ai", "tesztuser@gmail.com", "USER"); // ID: user, PW: kurva
			User ZoliAdmin = new User("XIXO", "$2a$10$85FmtL3FPSZZTuT04Bg4gegWSqkyCahLsxNAKxzTGlCB5kg6646/2", "szikszo.zoltan@gmail.com","ADMIN"); // ID: XIXO, PW: tesztelek
			User TesztAdmin = new User("adminteszt", "$2a$10$0ngVbYmZeFuBTrsyqLJOyuGrOKfugWck.Oy/Xk3JHivksSQ3fV0Q.", "teszt@gmail.com", "admin");

			userRepository.save(user1);
			userRepository.save(ZoliAdmin);
			userRepository.save(TesztAdmin);

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
