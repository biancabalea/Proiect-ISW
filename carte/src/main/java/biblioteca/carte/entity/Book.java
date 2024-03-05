package biblioteca.carte.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String rating;

    private String name;

    private String subject;

    private String language;

    private String description;

    private Long price;

    private Date year;

    @Column(columnDefinition = "longblob")
    private byte[] image;

}
