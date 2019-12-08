package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("greeting", "Hello " + name + "!");
        return "hello";
    }

    //create a handler to handle query requests /hello?name=userInput
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "helloForm")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }


    //lives at /form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<String>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Python");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
