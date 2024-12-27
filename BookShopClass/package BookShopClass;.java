package BookShopClass;
public class Book {
    private String id;
    private String bookName;
    private String authorName;
    private int soldBooks;
    private int reamingBooks;
    private int totalStock;
    private int price;
    public Book(String id, String bookName, String authorName, int soldBooks, int reamingBooks, int totalStock, int price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.soldBooks = soldBooks;
        this.reamingBooks = totalStock;
        this.totalStock = totalStock;
        this.price = price;
    }
    public String getId() {
        return id;
    }
    public String getBookName() {
        return bookName;
    }
    public String getAuthorName() {
        return authorName;
    }
    public int getSoldBooks() {
        return soldBooks;
    }
    public int getReamingBooks() {
        return reamingBooks;
    }
    public int getTotalStock() {
        return totalStock;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public void setSoldBooks(int soldBooks) {
        this.soldBooks = soldBooks;
    }
    public void setReamingBooks(int reamingBooks) {
        this.reamingBooks = reamingBooks;
    }
    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return id + ", " + bookName + ", " + authorName + ", " + soldBooks + ", " + reamingBooks + ", " + totalStock + ", " + price;
    }
}
‎src/main/java/BookShopClass/BookDataLoader.java
+68
Original file line number	Diff line number	Diff line change
@@ -0,0 +1,68 @@
package BookShopClass;
import BookShopClass.Book;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class BookDataLoader {
    public static void loadBookDataFromFile(String fileAddress, DefaultTableModel model) {
        ArrayList<Book> bookData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileAddress))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 7) {
                    String id = parts[0];
                    String bookName = parts[1];
                    String authorName = parts[2];
                    int soldBooks = Integer.parseInt(parts[3]);
                    int remainingBooks = Integer.parseInt(parts[4]);
                    int totalStock = Integer.parseInt(parts[5]);
                    int price = Integer.parseInt(parts[6]);
                    bookData.add(new Book(id, bookName, authorName, soldBooks, remainingBooks, totalStock, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateBookTable(model, bookData);
    }
    private static void updateBookTable(DefaultTableModel model, ArrayList<Book> bookData) {
        model.setRowCount(0); 
        for (Book book : bookData) {
            Object[] row = {
                    book.getId(),
                    book.getBookName(),
                    book.getAuthorName(),
                    book.getSoldBooks(),
                    book.getReamingBooks(),
                    book.getTotalStock(),
                    book.getPrice()
            };
            model.addRow(row); 
        }
    }
        public static void updateBookTable1(DefaultTableModel model, Book book) {
        model.setRowCount(0);  
            Object[] row = {
                    book.getId(),
                    book.getBookName(),
                    book.getAuthorName(),
                    book.getSoldBooks(),
                    book.getReamingBooks(),
                    book.getTotalStock(),
                    book.getPrice()
            };
            model.addRow(row); 
}
}
