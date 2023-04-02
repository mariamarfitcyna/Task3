import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        Library l = new Library(
                new Book("Alice in Wondeland", "Lewis Carroll", 1865),
                new Book("Harry Potter", "JR", 2001),
                new Book("CrossRoads", "Franzen", 2002),
                new Book("Of Human Bondage", "William Somerset Maugham", 1915));

        l.print();
        l.addAllBooks(new Book("Theatre", "William Somerset Maugham", 1937), new Book("Ulysses", "ffop", 1807));
        l.print();

        Book b = l.findBookByName("Ulysses");
        System.out.println(b.getAuthor());

        HashSet<Book> m = l.findBooksByAuthor("William Somerset Maugham");

    }
}