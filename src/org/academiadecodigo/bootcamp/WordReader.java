package org.academiadecodigo.bootcamp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class WordReader implements Iterable<String> {

    private String filePath;


    public WordReader(String filePath) {
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
        private FileReader reader = null;

        public MyIterator() {


            try {
                reader = new FileReader(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            bReader = new BufferedReader(reader);
            words = giveWords();
        }

        public String[] giveWords() {


            String line = "";

            try {

                line = bReader.readLine();
                if (line == null) {
                    bReader.close();
                    reader.close();
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
                if (index == words.length) {
                    words = giveWords();
                    index = 0;
                    return true;
                }
            }
            return false;

        }

        @Override
        public String next() {

            if (words == null) {
                return "";
            }

            return words[index++];

        }
    }
}

