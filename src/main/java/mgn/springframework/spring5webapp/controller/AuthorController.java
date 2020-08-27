package mgn.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import mgn.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
@AllArgsConstructor
public class AuthorController {

  private final AuthorRepository authorRepository;

  @RequestMapping("/authors")
  public final String getAuthors(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors/list";
  }
}
