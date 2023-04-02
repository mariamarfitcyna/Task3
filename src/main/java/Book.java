public class Book {

    public Book(String _name, String _author, int _released){
        name = _name;
        author = _author;
        released = _released;
    }
    private String name;
    private String author;
    private int released;

    public int getReleased() {
        return released;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }

    @Override
    public int hashCode() {
        int total = 31;

        total = total*(name.hashCode()/(name.length()));
        total = total + author.hashCode();
        total = total + released/10 + released;

        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book b = (Book) obj;
        return this.name.equals(b.getName()) & this.author.equals(b.getAuthor()) & this.released == b.getReleased();
    }
}
