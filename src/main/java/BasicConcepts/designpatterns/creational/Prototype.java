package BasicConcepts.designpatterns.creational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Book{
    private Integer bookId;
    private String bookName;


}

@ToString
class BookShop implements Cloneable{
    private List<Book> booklist = new ArrayList<>();
    private String bookShopName;

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    public String getBookShopName() {
        return bookShopName;
    }

    public void setBookShopName(String bookShopName) {
        this.bookShopName = bookShopName;
    }

    //we pretend that we load data from database
    public void getDataLoad(){
        for(int i =0;i< 3;i++){
            Book b = new Book();
            b.setBookId(i);
            b.setBookName("Book"+i);
            getBooklist().add(b);
        }
    }
    @Override
    protected BookShop clone() throws CloneNotSupportedException {
        //return super.clone(); //this is doing shallow cloning but we need deep cloning
        BookShop bs = new BookShop();
        for(Book b : this.getBooklist()){
            bs.getBooklist().add(b);
        }
        return bs;
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookShop bs = new BookShop();
        bs.getDataLoad();
        bs.setBookShopName("Abhishek");
        System.out.println(bs +" \n"+ bs.getBooklist());
        bs.getBooklist().remove(1);
        System.out.println(bs);

        BookShop bs1 = bs.clone();
        bs1.setBookShopName("Abhishek1");
        System.out.println(bs1);
    }
}
