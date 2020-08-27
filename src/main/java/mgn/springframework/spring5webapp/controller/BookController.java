package mgn.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import mgn.springframework.spring5webapp.repositories.BookRepository;

@Controller
@AllArgsConstructor
public class BookController {

  private final BookRepository bookRepository;

  @RequestMapping("/books")
  public final String getBooks(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "books/list";
  }
}
