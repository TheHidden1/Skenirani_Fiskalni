package mk.ukim.finki.skenirani_fiskalni.service.Impl;

import mk.ukim.finki.skenirani_fiskalni.models.Recepie;
import mk.ukim.finki.skenirani_fiskalni.repository.RecepieRepository;
import mk.ukim.finki.skenirani_fiskalni.service.RecepieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RecepieServiceImpl implements RecepieService {

    @Autowired
    private RecepieRepository recepieRepository;
    @Override
    public Recepie uploadImage(String actual, String expected, MultipartFile file) throws IOException {
    return  null;
    }
}
