package lesson18.dao;

import lesson18.config.DbConfig;
import lesson18.model.Book;
import lesson18.model.Library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAOImpl implements BookDAO{

    private Connection connection;

    private String scriptSQL;

    public BookDAOImpl() {
        this.connection = new DbConfig().getConnection();
    }

    @Override
    public void addBook(Book book) {
        scriptSQL = "INSERT INTO book (title,author) Values (?, ?)";
        this.connectionWithoutResult(scriptSQL,book);
    }

    @Override
    public void delBook(Book book) {
        scriptSQL =  "DELETE FROM book WHERE title = ? AND author = ?";
        this.connectionWithoutResult(scriptSQL,book);
    }

    @Override
    public Library getLib() {
        Library lib = new Library();
        String scriptSQL = "SELECT * FROM book";

        PreparedStatement preparedStatement;
        ResultSet result;

        try {
            preparedStatement = connection.prepareStatement(scriptSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            result = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            while(result.next()) {
                lib.getBooks().add(new Book(result.getString(2), result.getString(3)));
            }
        } catch (SQLException e) {
               throw new RuntimeException(e);
        }

        return lib;
    }

    private void connectionWithoutResult(String scriptSQL, Book book){

        PreparedStatement preparedStatement;

        try{
            preparedStatement = connection.prepareStatement(scriptSQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try{
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
