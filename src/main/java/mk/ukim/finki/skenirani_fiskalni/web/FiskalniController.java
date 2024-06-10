package mk.ukim.finki.skenirani_fiskalni.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FiskalniController {


    @GetMapping("/")
    public String index(){
        return "index";
    }
}
