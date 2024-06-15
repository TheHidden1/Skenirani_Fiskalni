package mk.ukim.finki.skenirani_fiskalni.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Data
@NoArgsConstructor
public class Recepie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String actual;
    private String expected;
    @Lob
    private byte[] image;

    public  Recepie(String actual, String expected, byte[] image){
        this.actual= actual;
        this.expected= expected;
        this.image = image;
    }


}
