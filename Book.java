import java.util.Comparator;

public class Book implements Comparable<Book> {
    public String name;
    public String auther;
    public int price;

    public Book(String name, String auther, int price) {
        this.name = name;
        this.auther = auther;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;
        return this.name.equals(book.name);
    }

    public static void main(String[] args) {
        Book book1 = new Book("三国", "罗贯中", 100);
        Book book2 = new Book("三国演绎", "罗贯中", 100);
        System.out.println(book1.equals(book2));
        System.out.println(book1.compareTo(book2));
    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }
}
