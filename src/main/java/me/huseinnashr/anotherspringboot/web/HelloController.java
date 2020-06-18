package me.huseinnashr.anotherspringboot.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class HelloController {
    @RequestMapping(value = "/basic")
    public String sayHello() {
        return "<h1>Hello</h1>";
    }

    @RequestMapping(value = "/proper")
    public String sayPreporHello() {
        return "<h1>Hello, how are you?</h1>";
    }

    @RequestMapping(value = "/user_entry")
    public String form() {
        return "<form action='./user_greeting' method='POST'>" + "First name: "
                + "<input type='text' name='firstname'/><br>" + "Last name: "
                + "<input type='text' name='lastname'/><br>" + "<input type='submit'/>" + "</form>";
    }

    @RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
    public String printUserGreeting(@RequestParam String firstname, @RequestParam String lastname) {
        return "Hello there " + firstname + " " + lastname;
    }

    @RequestMapping(value = "/orders/{id}/{dd}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String dd, @PathVariable String id) {
        return "Order ID: " + id + dd;
    }
}
