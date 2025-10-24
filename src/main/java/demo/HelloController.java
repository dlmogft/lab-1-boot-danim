package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller to load the template hello.html
 * using the thymeleaf extension
 *
 * Don't use @ResponseBody in the return unless we want to return a plain text
 * Without @ResponseBody the method points to src/main/resources/templates/hello.html
 */
@Controller
public class HelloController {

    @GetMapping("/")
    public String helloThere() {
        return "hello";
    }

}
