package ru.sberbank.allure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for reading file.
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 10.02.2017.
 */
public class FileReaders {
    /**
     * Constructor for the class FileReaders.
     */
    private FileReaders() {
    }

    /**
     * The method of reading file.
     * @param file - file for testing.
     * @return ArrayList<> operations.
     */
    public static List<String[]> readFile(String file) {
        List<String[]> operations = new ArrayList<String[]>();
        BufferedReader br = null;
        String line = "";
        String splitter = ";";
        try {
            br = new BufferedReader(new java.io.FileReader(file));
            while ((line = br.readLine()) != null) {
                final String[] row = line.split(splitter);
                operations.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return operations;
    }
}
