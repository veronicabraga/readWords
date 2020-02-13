package org.academiadecodigo.bootcamp;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        try {
            //WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text");
            //WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text2");
            WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text2");
            //wordReader.giveWords();

            for (String word : wordReader) {
                System.out.println(word);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
