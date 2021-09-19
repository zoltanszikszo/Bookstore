package zoltanszikszo.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import zoltanszikszo.Bookstore.domain.Book;
import zoltanszikszo.Bookstore.domain.BookRepository;

@Controller
public class BookstoreController {

    @Autowired
    private BookRepository repository;

    @RequestMapping("/booklist")
    public String bookList (Model model){
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    @RequestMapping("/add")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @PostMapping("/save")
    public String saveBook(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
    @GetMapping("/delete/{id}")
        public String deleteBook(@PathVariable("id") Long bookId, Model model){
            repository.deleteById(bookId);
            return "redirect:../booklist";
    }

    @RequestMapping("/edit/{id}")
    public String addBook(@PathVariable("id") Long bookId, Model model){
        model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }
}
