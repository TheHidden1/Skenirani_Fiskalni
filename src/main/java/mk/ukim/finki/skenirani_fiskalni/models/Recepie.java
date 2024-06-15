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
    @GeneratedValue
    private Long Id;
    @Column(length = 8196)
    private String actual;
    @Column(length = 8196)
    private String expected;
    private String image;

    public  Recepie(String actual, String expected, String image){
        this.actual= actual;
        this.expected= expected;
        this.image = image;
    }


}
