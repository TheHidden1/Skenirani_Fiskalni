package mk.ukim.finki.skenirani_fiskalni.web;

import mk.ukim.finki.skenirani_fiskalni.models.Receipt;
import mk.ukim.finki.skenirani_fiskalni.service.ReceiptService;
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
import java.util.UUID;

@Controller
public class FiskalniController {
    @Autowired
    ReceiptService receiptService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/check/{id}")
    public String index(@PathVariable UUID id, Model model) {
        Receipt receipt = receiptService.findById(id).get();
        model.addAttribute("receipt", receipt);
        return "check";
    }
    @PostMapping("/uploadReceipt")
    public String handleFileUpload(@RequestParam("fileUpload") MultipartFile file) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("image", file.getResource());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String pythonApiUrl = "http://127.0.0.1:5000/ocr";

        ResponseEntity<String> response = restTemplate.exchange(pythonApiUrl, HttpMethod.POST, requestEntity, String.class);
        File directory = new File("src/main/resources/static/images");
        UUID id = UUID.randomUUID();
        while (receiptService.findById(id).isPresent()) {
            id = UUID.randomUUID();
        }
        String extenstion = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newName = id.toString().replaceAll("-","0") + extenstion;
        Path filePath = Paths.get("src/main/resources/static/images", newName);
        Files.write(filePath, file.getBytes());
        Receipt receipt = new Receipt(id ,response.getBody(), response.getBody(), "/images/" + newName);
        receiptService.save(receipt);
        return "redirect:/check/" + receipt.getId();
    }
    @PostMapping("/submitReceipt")
    public String submitReceipt(@RequestParam UUID id, @RequestParam String actual) {
        Receipt receipt = receiptService.findById(id).get();
        receipt.setActual(actual);
        receiptService.save(receipt);
        return "redirect:/";
    }
}
