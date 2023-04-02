import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private Set<Book> books;

    public Library(){
        books = new HashSet<>();
    }

    public Library(Book...v){
        books = new HashSet<>(Arrays.asList(v));
    }

    public void print(){
        for (Book i : books){
            System.out.println(i.getName());
        }
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addAllBooks(Book...v){
        books.addAll(List.of(v));
    }

    public void removeBook(Book book){
        books.remove(book);
    }

    public void removeBooks(Book ...v){
        books.removeAll(List.of(v));
    }

    public void removeBook(String name){
        Book myBook = findBookByName(name);
        books.remove(myBook);
    }

    public Book findBookByName(String name){
        Book myBook = books
                .stream()
                .filter(book -> (book.getName().equals(name)))
                .findFirst()
                .orElse(null);
        return myBook;
    }

    public HashSet<Book> findBooksByAuthor(String author){
        List<Book> myBooks = books
                .stream()
                .filter(book -> (book.getAuthor().equals(author)))
                .collect(Collectors.toList());
        HashSet<Book> foundBooks = new HashSet<>(myBooks);
        return foundBooks;

    }
    public HashSet<Book> findBooksByData(int released){
        List<Book> myBooks = books
                .stream()
                .filter(book -> (book.getReleased() == released))
                .collect(Collectors.toList());
        HashSet<Book> foundBooks = new HashSet<>(myBooks);
        return foundBooks;

    }

    public HashSet<Book> findBooksByDataInterval(int released1, int released2){
        List<Book> myBooks = books
                .stream()
                .filter(book -> ((book.getReleased() < released2 + 1) & (released1 -1 < book.getReleased())))
                .collect(Collectors.toList());
        HashSet<Book> foundBooks = new HashSet<>(myBooks);
        return foundBooks;

    }
}
