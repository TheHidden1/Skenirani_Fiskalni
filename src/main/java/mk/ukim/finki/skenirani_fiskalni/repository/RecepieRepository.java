package mk.ukim.finki.skenirani_fiskalni.repository;

import mk.ukim.finki.skenirani_fiskalni.models.Recepie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecepieRepository extends JpaRepository<Recepie, Long> {

}
