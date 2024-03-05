package biblioteca.carte.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class BookDto {
    private Long id;

    private String author;

    private String rating;

    private String name;

    private String subject;

    private String language;

    private String description;

    private Long price;

    private Date year;

    private byte[] returnedImage;

    private MultipartFile image;

}
