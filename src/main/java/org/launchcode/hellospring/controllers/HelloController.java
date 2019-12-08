package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class HelloController {

    public static String createMessage(String name, String language) {
        if (language.equals("english")) {
            return "Hello " + name + "!";
        } else if (language.equals("spanish")) {
            return "Hola " + name + "!";
        } else if (language.equals("portuguese")) {
            return "Olá " + name + "!";
        } else if (language.equals("latin")) {
            return "Salve " + name + "!";
        } else if (language.equals("french")) {
            return "Bonjour " + name + "!";
        } else {
            return "Hello " + name + "!";
        }
    }

    //handles request at path /childPath
    @GetMapping()
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //create a handler to handle query requests /hello?name=userInput
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }


    //lives at /form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

}
