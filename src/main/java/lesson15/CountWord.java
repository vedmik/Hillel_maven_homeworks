package lesson15;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountWord {

    public void countUniqueWordsAndSaveFile(String filePathWithDirectory){
        Map<String,Long> uniqueWords = new HashMap<>();

        try(FileReader fileReader = new FileReader(filePathWithDirectory)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            uniqueWords = bufferedReader.lines()
                    .flatMap(w -> Stream.of(w.split("[\\p{Punct}\\s]")))
                    .map(String::toLowerCase)
                    .filter(s -> !s.isEmpty() && s.length() >= 3)
                    .sorted()
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        addResultToFile(filePathWithDirectory, uniqueWords);
    }

    private void addResultToFile(String filePathWithDirectory, Map<String, Long> uniqueWords) {

        String file = parsingPatch(filePathWithDirectory);

        try(PrintWriter pw = new PrintWriter(new FileOutputStream(file))){


            for(Map.Entry<String, Long> m : uniqueWords.entrySet()){
                pw.println(m.getKey()+"="+m.getValue());
            }

            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parsingPatch(String filePathWithDirectory){

        String file = Arrays.stream(filePathWithDirectory.split("/"))
                .map(s -> {
                    if(s.contains(".")){
                        return "/result_" + s;
                    }
                    return "/" + s;
                })
                .collect(Collectors.joining()).replaceFirst("/","");

        return file;
    }
}
