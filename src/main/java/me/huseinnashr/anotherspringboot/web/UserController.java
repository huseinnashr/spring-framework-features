package me.huseinnashr.anotherspringboot.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.huseinnashr.anotherspringboot.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping(path = "{userId}")
  public String displayUser(@PathVariable int userId) {
    return "User Found: " + userId;
  }

  @GetMapping(path = "{userId}/invoices")
  public String displayUserInvoices(@PathVariable int userId,
      @RequestParam(value = "date", required = false) Date dateOrNull) {
    return "invoice found for user: " + userId + " on the date " + dateOrNull;
  }

  @GetMapping(value = "{userId}/items")
  public List<String> displayStringJson() {
    return Arrays.asList("Shoes", "Laptop", "Button");
  }

  @GetMapping(value = "{userId}/products_as_json")
  public List<Product> displayProductsJson() {
    return Arrays.asList(new Product(1, "shoes", 42.99), new Product(2, "books", 12.99), new Product(3, "bag", 45.99));
  }

}