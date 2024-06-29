package mk.ukim.finki.skenirani_fiskalni.service;

import mk.ukim.finki.skenirani_fiskalni.models.Receipt;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ReceiptService {

    public Receipt uploadImage(String actual, String expected, MultipartFile file) throws IOException;
    public Optional<Receipt> findById(UUID id);
    public void save(Receipt receipt);
}
