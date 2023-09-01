// Design a class Book containing following members: 
// bookID text 
// title text 
// author text 
// category text 
// price double
// Define Parameterized constructor to initialize Book object. Perform the below validations 
// • Category must be “Science”, “Fiction”, “Technology” or “Others” 
// • Price cannot be negative 
// • bookID must start with ‘B’ and must be of length 4 characters 

// If any of the validations fail, throw an user defined exception InvalidBookException. 
// Design a class called BookStore which contains an appropriate collection object to store Book instances. 
// Implement the below operations. 
// 1. addBook(Book b)     To add a new Book object into the book table 
// 2. searchByTitle(String title)   Search a book from DB based on title and if found, display the details 
// 3. searchByAuthor(String author) Search a book from DB based on author and if found, display the details 
// 4. displayAll()  Print the details of all the books 
// Store both classes in a package com.book. 
// Create a class BookUtil in package com.bookutil which has the main method. 
// • Instantiate the BookStore class 
// • Read data from user for 3 Book objects. 
// • Call the addBook method to add the book objects into the collection 
// • Search the books by title and author 
// • Display all the book details 

package org.example.book;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String category;
    private double price;
    public Book(){}
    public Book(String bookId, String title, String author, String category, double price){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return bookId+" "+title+" "+author+" "+category+" "+price;
    }
}

package org.example.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//DAO class
public class BookStore {

    private static String url = "jdbc:mysql://localhost:3306/gainsight";

//    To add a new book object into books table
    public boolean addBook(Book b){
        int count = 0;
        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("insert into books values(?,?,?,?,?)") ){
            pst.setString(1, b.getBookId());
            pst.setString(2,b.getTitle());
            pst.setString(3,b.getAuthor());
            pst.setString(4,b.getCategory());
            pst.setDouble(5,b.getPrice());
            count = pst.executeUpdate();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return count==1;
    }

//    Search a book based onn title
    public Book searchByTitle(String title){
        Book book = null;
        try (Connection con = DriverManager.getConnection(url,"root","G@1nsight");
            PreparedStatement pst = con.prepareStatement("select * from books where title = ?")){
            pst.setString(1,title);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
                book = new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return book;
    }

//    Search book based on author
    public ArrayList<Book> searchByAuthor(String author){
        ArrayList<Book> bookList = new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,"root","G@1nsight");
            PreparedStatement pst = con.prepareStatement("select * from books where author = ?")){
            pst.setString(1,author);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                bookList.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bookList;
    }

//    To print the details of the book
    public void displayAll(){

        try (Connection con = DriverManager.getConnection(url, "root", "G@1nsight");
             PreparedStatement pst = con.prepareStatement("select * from books");) {
            ResultSet rs = pst.executeQuery();
            while(rs.next())
                System.out.println(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}

package org.example.bookutil;

import org.example.book.Book;
import org.example.book.BookStore;
import java.util.ArrayList;
import java.util.Scanner;

class InvalidBookException extends RuntimeException{
    private String message = null;
    public InvalidBookException(){
        message = "Book details entered are INVALID!";
    }
    public InvalidBookException(String message){
        this.message = message;
    }
    public String toString(){
        return "InvalidBookException:"+message;
    }
}

public class BookUtil {
    BookStore bs = new BookStore();
    public void addBookDetails(Book b){
        if(bs.addBook(b))
            System.out.println("Book details added successfully");
        else
            System.out.println("Book insertion FAILED!!");
    }
    public void searchBookByTitle(String title){
        Book b = bs.searchByTitle(title);
        if(b!=null)
            System.out.println(b);
        else
            System.out.println("Book does not exist");

    }
    public void searchBooksByAuthor(String author){
        ArrayList<Book> bookList = bs.searchByAuthor(author);
        for(Book b : bookList)
            System.out.println(b);
    }
    public void displayAllDetails(){
        bs.displayAll();
    }
    public static void main(String[] args) {

        BookUtil bookUtilObj = new BookUtil();
        Scanner scanner = new Scanner(System.in);

//        Entering book details
        while(true){
            System.out.println("Do you want to enter details of a book? (Y/N)");
            char choice = scanner.next().charAt(0);
            if(choice !='Y' && choice!='y')
                break;
            System.out.println("Enter book details:");
            String bookId = scanner.next();
            String title = scanner.next();
            String author = scanner.next();
            String category = scanner.next();
            double price = scanner.nextDouble();
            if(!category.equals("Science") && !category.equals("Fiction") && !category.equals("Technology") && !category.equals("Others"))
                throw new InvalidBookException("Invalid title");
            if(price<0)
                throw new InvalidBookException("Price cannot be negative");
            if(bookId.charAt(0)!='B')
                throw new InvalidBookException("Book Id must start with 'B' ");
            bookUtilObj.addBookDetails(new Book(bookId,title,author,category,price));

        }

//        Get book by title
        System.out.println("Enter title to get book details");
        String title = scanner.next();
        bookUtilObj.searchBookByTitle(title);

//        Get book by author
        System.out.println("Enter author to get book details");
        String author = scanner.next();
        bookUtilObj.searchBooksByAuthor(author);

//        Display list of all books
        bookUtilObj.displayAllDetails();

    }

}

