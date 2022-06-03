package lesson18retr.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Book implements Serializable {
    private String title;
    private String author;

}
