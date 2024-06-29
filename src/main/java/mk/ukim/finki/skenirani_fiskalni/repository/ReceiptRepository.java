package mk.ukim.finki.skenirani_fiskalni.repository;

import mk.ukim.finki.skenirani_fiskalni.models.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    Optional<Receipt> findById(UUID id);
}
