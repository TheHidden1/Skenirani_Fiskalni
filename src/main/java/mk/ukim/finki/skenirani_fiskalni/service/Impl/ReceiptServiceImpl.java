package mk.ukim.finki.skenirani_fiskalni.service.Impl;

import mk.ukim.finki.skenirani_fiskalni.models.Receipt;
import mk.ukim.finki.skenirani_fiskalni.repository.ReceiptRepository;
import mk.ukim.finki.skenirani_fiskalni.service.ReceiptService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
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
