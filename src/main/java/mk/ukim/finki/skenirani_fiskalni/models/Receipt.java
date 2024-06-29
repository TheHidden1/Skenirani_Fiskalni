package mk.ukim.finki.skenirani_fiskalni.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Receipt {

    @Id
    private UUID Id;
    @Column(length = 8196)
    private String actual;
    @Column(length = 8196)
    private String expected;
    private String image;

    public  Receipt(UUID id,String actual, String expected, String image){
        this.Id= id;
        this.actual= actual;
        this.expected= expected;
        this.image = image;
    }


}
