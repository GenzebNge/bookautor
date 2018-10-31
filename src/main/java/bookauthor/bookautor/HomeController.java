package bookauthor.bookautor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AutorRepository autorRepository;

    @RequestMapping("/index")
    public String index(Model model){
        Set<Autor> autors = new HashSet<Autor>();
        Set<Book> books = new HashSet<Book>();
        Book book = new Book();

        Autor autor = new Autor();

        autor.setName("Simeneh");
        autor.setGender("Male");

        //add autor to an empity set

        autors.add(autor);
        autorRepository.save(autor);

        Autor autor1 = new Autor();
        autor.setName("Melak");
        autor.setGender("Female");
        autors.add(autor1);
        autorRepository.save(autor1);


        // create anew book

        book.setTitle("Introduction to Java");
      //add books to empity list

        books.add(book);
      //add list of books to the autor
        autor.setBooks(books);
        // save the book to book repository

        bookRepository.save(book);
        Book book1 = new Book();
        book1.setTitle("csharp");
        books.add(book1);
        autor.setBooks(books);
        bookRepository.save(book1);

        model.addAttribute("autor" , autorRepository.findAll());
        model.addAttribute("book", bookRepository.findAll());

        return "index";
    }
}
