package me.huseinnashr.anotherspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.huseinnashr.anotherspringboot.domain.User;

@Controller
@RequestMapping("")
public class HomeController {

  @GetMapping
  public String home(Model model) {
    model.addAttribute("formData", new User());

    return "index";
  }

  @PostMapping(value = "/create")
  public String processFormData(User user, RedirectAttributes attr) {

    attr.addFlashAttribute("user", user);
    return "redirect:/display";
  }

  @GetMapping(value = "display")
  public String displayFormData(User user) {
    return "result";
  }

}