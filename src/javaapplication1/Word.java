/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 * @author Admin
 */
public class Word implements Comparable<Word> {
    public String word_target, word_explain, word_pronounce;

    public Word(String s1, String s2, String s3) {
        word_target = s1;
        word_pronounce=s2;
        word_explain = s3;
    }

    @Override
    public int compareTo(Word o) {
        return this.word_target.compareToIgnoreCase(o.word_target);
    }

    @Override
    public String toString() {
        return word_target + "\t" + word_explain;
    }
}
