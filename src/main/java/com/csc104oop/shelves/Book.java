package com.csc104oop.shelves;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book 
{
    private int id;
    private String title;
    private String author;
    private String dateReleased;
    private String genre;
    private int pages;

    public Book(int id, String title, String author, String dateReleased, String genre, int pages)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateReleased = dateReleased;
        this.genre = genre;
        this.pages = pages;
    }

    public Integer getId()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getDateReleased()
    {
        return dateReleased;
    }

    public String getGenre()
    {
        return genre;
    }

    public Integer getPages()
    {
        return pages;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setDateReleased(String dateReleased)
    {
        this.dateReleased = dateReleased;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setPages(int pages)
    {
        this.pages = pages;
    }

    public static ResultSet getBooksFromShelf() throws SQLException, IOException
    {
        String sql = "SELECT * FROM shelf";

        Statement statement = ConnectDb.getStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

    public static void deleteBook(int id) throws IOException
    {
        String sql = "DELETE FROM shelf WHERE book_id = ?";
        
        Connection conn = ConnectDb.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
    }

    public static void insertBook(Book book) throws IOException
    {
        String sql = "INSERT INTO shelf (book_title, book_author, book_genre, book_date_released, book_numpages) ";
        sql += "VALUES(?,?,?,?,?)";

        Connection conn = ConnectDb.getConnection();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setString(4, book.getDateReleased());
            preparedStatement.setInt(5, book.getPages());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public static void updateBook(Book book) throws IOException
    {
        String sql = "UPDATE shelf SET book_title = ?, "
                   + "book_author = ?, book_genre = ?, "
                   + "book_date_released = ?, book_numpages = ? "
                   + "WHERE book_id = ?";

        Connection conn = ConnectDb.getConnection();
        PreparedStatement preparedStatement;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setString(4, book.getDateReleased());
            preparedStatement.setInt(5, book.getPages());
            preparedStatement.setInt(6, book.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

}


