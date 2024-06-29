package mk.ukim.finki.skenirani_fiskalni.service.Impl;

import mk.ukim.finki.skenirani_fiskalni.models.Receipt;
import mk.ukim.finki.skenirani_fiskalni.repository.ReceiptRepository;
import mk.ukim.finki.skenirani_fiskalni.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;
    @Override
    public Receipt uploadImage(String actual, String expected, MultipartFile file) throws IOException {
    return  null;
    }

    @Override
    public Optional<Receipt> findById(UUID id) {
        return receiptRepository.findById(id);
    }

    @Override
    public void save(Receipt receipt) {
        receiptRepository.save(receipt);
    }
}
