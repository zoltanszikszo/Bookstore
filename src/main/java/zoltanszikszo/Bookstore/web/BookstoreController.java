package zoltanszikszo.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zoltanszikszo.Bookstore.domain.Book;

@Controller
public class BookstoreController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("title", new Book());
        model.addAttribute("author", new Book());
        model.addAttribute("year", new Book());
        model.addAttribute("isbn", new Book());
        model.addAttribute("price", new Book());
        return "hello";
    }
}
