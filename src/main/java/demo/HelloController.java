package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // Don't use @ResponseBody in the return unless we want to return a plain text
    // Without @ResponseBody the method points to src/main/resources/templates/hello.html
    @GetMapping("/")
    public String helloThere() {
        return "hello";
    }

}
