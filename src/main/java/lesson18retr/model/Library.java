package lesson18retr.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Library {
    private List<Book> books = new ArrayList<>();
}
