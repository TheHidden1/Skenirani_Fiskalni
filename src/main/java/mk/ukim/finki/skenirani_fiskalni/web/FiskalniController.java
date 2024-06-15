package mk.ukim.finki.skenirani_fiskalni.web;

import mk.ukim.finki.skenirani_fiskalni.models.Recepie;
import mk.ukim.finki.skenirani_fiskalni.service.RecepieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FiskalniController {
    @Autowired
    RecepieService recepieService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/check/{id}")
    public String index(@PathVariable Long id, Model model) {
        Recepie recepie = recepieService.findById(id).get();
        model.addAttribute("recepie", recepie);
        return "check";
    }
    @PostMapping("/uploadRecipe")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String pythonApiUrl = "https://f79b-46-217-149-128.ngrok-free.app/ocr";

        ResponseEntity<String> response = restTemplate.exchange(pythonApiUrl, HttpMethod.POST, requestEntity, String.class);
        File directory = new File("src/main/resources/static/images");
        Path filePath = Paths.get("src/main/resources/static/images", file.getOriginalFilename());
        Files.write(filePath, file.getBytes());
        Recepie recepie = new Recepie(response.getBody(), response.getBody(), "/images/" + file.getOriginalFilename());
        recepieService.save(recepie);
        System.out.println(recepie.toString());
        return "redirect:/check/" + recepie.getId();
    }
}
