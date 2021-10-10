package zoltanszikszo.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import zoltanszikszo.Bookstore.domain.Book;
import zoltanszikszo.Bookstore.domain.BookRepository;
import zoltanszikszo.Bookstore.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class BookstoreController {

    @Autowired
    private BookRepository repository;

    @Autowired
    private CategoryRepository crepository;

    @RequestMapping("/booklist")
    public String bookList (Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> studentListRest() {
        return (List<Book>) repository.findAll();
    }

    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId){
        return repository.findById(bookId);
    }

    @RequestMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }
    @PostMapping("/save")
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
        public String deleteBook(@PathVariable("id") Long bookId, Model model){
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
        public String addBook(@PathVariable("id") Long bookId, Model model){
        model.addAttribute("book", repository.findById(bookId));
        model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }


}
