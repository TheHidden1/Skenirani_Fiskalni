package mk.ukim.finki.skenirani_fiskalni.service;

import mk.ukim.finki.skenirani_fiskalni.models.Recepie;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public interface RecepieService {

    public Recepie uploadImage(String actual, String expected, MultipartFile file) throws IOException;
    public Optional<Recepie> findById(Long id);
    public void save(Recepie recepie);
}
