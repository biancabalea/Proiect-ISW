package biblioteca.carte.services.admin;

import biblioteca.carte.dto.BookDto;
import biblioteca.carte.entity.Book;
import biblioteca.carte.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private  final BookRepository bookRepository;

    @Override
    public boolean postBook(BookDto bookDto) throws IOException {
        try {
            Book book = new Book();
            book.setName(bookDto.getName());
            book.setAuthor(bookDto.getAuthor());
            book.setRating(bookDto.getRating());
            book.setPrice(bookDto.getPrice());
            book.setYear(bookDto.getYear());
            book.setSubject(bookDto.getSubject());
            book.setDescription(bookDto.getDescription());
            book.setLanguage(bookDto.getLanguage());
            book.setImage(bookDto.getImage().getBytes());
            bookRepository.save(book);
            return true;
        } catch(Exception e){
            return false;
        }

    }
}
