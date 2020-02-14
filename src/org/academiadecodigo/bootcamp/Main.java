package org.academiadecodigo.bootcamp;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

            //WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text");
            //WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text2");
            WordReader wordReader = new WordReader("/Users/codecadet/workspace/readWords/resources/Text2");
            //wordReader.giveWords();

            for (String word : wordReader) {
                System.out.println(word);
            }

            Iterator iterator = wordReader.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
    }
}
