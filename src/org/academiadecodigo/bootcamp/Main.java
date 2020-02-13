package org.academiadecodigo.bootcamp;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        try {
            WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text");

            wordReader.giveWords();

            for (String word : wordReader) {
                System.out.println(word);
            }

            Iterator<String> iterator = wordReader.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
