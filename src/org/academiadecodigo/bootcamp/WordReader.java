package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String> {

    private String filePath;


    public WordReader(String filePath) throws FileNotFoundException {
        this.filePath = filePath;

    }


    @Override
    public Iterator<String> iterator() {
        return new MyIterator();

    }

    private class MyIterator implements Iterator<String> {

        private int index;
        private String[] words;
        private BufferedReader bReader;

        public MyIterator() {
            FileReader reader = null;

            try {
                reader = new FileReader(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            bReader = new BufferedReader(reader);
            giveWords();
        }

        public String[] giveWords() {


            String line = "";

            try {

                line = bReader.readLine();
                if (line == null) {
                    bReader.close();
                    words = null;
                    return null;
                }
                words = line.split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }


            return words;

        }

        @Override
        public boolean hasNext() {


            if (words != null) {
                if (index < words.length) {

                    return true;
                }
            }
            return false;

        }

        @Override
        public String next() {


            if ((index + 1) == words.length) {
                giveWords();
                index = 0;
            }

            if (words == null) {
                return "";
            }

            return words[index++];

        }
    }
}

