package com.csc104oop.shelves;


import java.io.IOException;
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

    public static ResultSet getBooksFromShelf() throws SQLException, IOException
    {
        String sql = "SELECT * FROM shelf";

        Statement statement = ConnectDb.getStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        return resultSet;
    }

}
