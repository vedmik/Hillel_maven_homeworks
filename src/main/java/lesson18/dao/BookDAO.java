package lesson18.dao;

import lesson18.model.Book;
import lesson18.model.Library;

import java.sql.SQLException;

public interface BookDAO {
    public void addBook(Book book);
    public void delBook(Book book);
    public Library getLib() throws SQLException;
}
