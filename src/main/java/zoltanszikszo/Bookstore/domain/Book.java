package zoltanszikszo.Bookstore.domain;

public class Book {

    private String title;
    private String author;
    private int year;
    private String isbn;
    private int price;

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(){
        this.author = author;
    }

    public int getYear(){
        return year;
    }

    public void setYear(){
        this.year = year;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setIsbn(){
        this.isbn = isbn;
    }

    private int getPrice(){
        return price;
    }

    private void setPrice(){
        this.price = price;
    }
}
