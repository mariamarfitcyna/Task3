import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private Set<Book> books;
    private HashMap<String, Book> namesCatalog;
    private HashMap<String, HashSet<Book>> authorCatalog;
    private HashMap<Integer, HashSet<Book>> dataCatalog;

    public Library(){
        books = new HashSet<>();
        namesCatalog = new HashMap<>();
        authorCatalog = new HashMap<>();
        dataCatalog = new HashMap<>();
    }

    public Library(Book...v){
        books = new HashSet<>(Arrays.asList(v));
        for (Book book: v){
            addBookToHashMaps(book);
        }
    }

    private void addBookToHashMaps(Book book){
        namesCatalog.put(book.getName(), book);

        String authorKey = book.getAuthor();
        if (authorCatalog.containsKey(authorKey)){
            authorCatalog.get(authorKey).add(book);
        }else {
            authorCatalog.put(authorKey, new HashSet<>(List.of(book)));
        };

        Integer releasedKey = book.getReleased();
        if (dataCatalog.containsKey(releasedKey)){
            dataCatalog.get(releasedKey).add(book);
        }else {
            dataCatalog.put(releasedKey, new HashSet<>(List.of(book)));
        };
    }

    private void removeBookFromHashMaps(Book book){
        namesCatalog.remove(book.getName());
        authorCatalog.get(book.getAuthor()).remove(book);
        dataCatalog.get(book.getReleased()).remove(book);
    }


    public void print(){
        for (Book i : books){
            System.out.println(i.getName());
        }
    }

    public void addBook(Book book){
        books.add(book);
        addBookToHashMaps(book);

    }

    public void addAllBooks(Book...v){
        books.addAll(List.of(v));
        for (Book i : v){
            addBookToHashMaps(i);
        }
    }

    public void removeBook(Book book){
        books.remove(book);
        removeBookFromHashMaps(book);
    }

    public void removeBooks(Book ...v){
        books.removeAll(List.of(v));
        for (Book i : v){
            removeBookFromHashMaps(i);
        }
    }

    public void removeBook(String name){
        Book myBook = findBookByName(name);
        books.remove(myBook);
    }

    public Book findBookByName(String name){
        Book book = namesCatalog.get(name);
        return book;
    }

    public HashSet<Book> findBooksByAuthor(String author){
        HashSet<Book> bookList = authorCatalog.get(author);
        return new HashSet<>(bookList);
    }

    public HashSet<Book> findBooksByData(int released){
        HashSet<Book> bookList = dataCatalog.get(released);
        return new HashSet<>(bookList);
    }

    public HashSet<Book> findBooksByDataInterval(int released1, int released2){
        List<Book> bookList = new ArrayList<>();
        for (int i = released1; i < released2 + 1; i++){
            if (dataCatalog.containsKey(i)){
                bookList.addAll(dataCatalog.get(i));
            }
        }
        return new HashSet<>(bookList);
    }

}
