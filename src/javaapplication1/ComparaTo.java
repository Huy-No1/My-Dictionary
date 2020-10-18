package javaapplication1;

import java.util.Comparator;

public class ComparaTo implements Comparator<Word> {


    @Override
    public int compare(Word s1, Word s2) {

        return s1.word_target.compareToIgnoreCase(s2.word_target);

    }

}

