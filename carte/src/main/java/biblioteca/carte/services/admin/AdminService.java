package biblioteca.carte.services.admin;

import biblioteca.carte.dto.BookDto;

import java.io.IOException;

public interface AdminService {

    boolean postBook(BookDto bookDto) throws IOException;
}
