package lesson18retr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson18retr.model.Library;

import java.io.File;
import java.io.IOException;

public class LibSerializer {
    public static File file;
    private ObjectMapper mapper;

    public LibSerializer(ObjectMapper mapper, String dir) {
        file = new File(dir);
        this.mapper = mapper;
    }

    public void writeToFile(Library lib) {

        try{
            mapper.writeValue(file, lib);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Library readFromFile(){
        try {
            file.createNewFile();
            return mapper.readValue(file, Library.class);

        } catch (IOException e) {
            return new Library();
        }
    }
}
