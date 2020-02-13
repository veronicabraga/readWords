package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String>{

    FileReader reader;
    String[] words;


    public WordReader(String filePath) throws FileNotFoundException {
        reader = new FileReader(filePath);
    }

    public String[] giveWords() throws IOException {

        BufferedReader bReader = new BufferedReader(reader);

        String line = "";
        String result = "";


        // using the buffered reader we can read lines
        while((line = bReader.readLine()) != null) {
            result += line + "\n";
            words = result.split(" ");
        }

        bReader.close();

        //return result;
        return words;

    }



    @Override
    public Iterator<String> iterator() {
        return new MyIterator();

    }

    private class MyIterator implements Iterator<String> {

        int index;

        @Override
        public boolean hasNext() {

            if (index < words.length) {
                return true;
            }
            return false;
        }

        @Override
        public String next() {
            return words[index++];

        }
    }
}

