/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Admin
 */
import java.util.Scanner;

public class DictionaryCommandLine {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void print(String s) {
        System.out.printf(s);
        for (int i = 0; i < 20 - s.length(); i++)
            System.out.printf(" ");
        //System.out.println();
    }

    public void showAllWords() {
        System.out.println("No\t\t\t\t\tEnglish\t\t\t\tVietNamese");
        for (int i = 0; i < dictionaryManagement.Dic.ListWord.size(); i++) {
            //System.out.println(i + 1 + "       " + dictionaryManagement.Dic.ListWord.get(i).word_target + "\t\t\t" + dictionaryManagement.Dic.ListWord.get(i).word_explain);
            print(String.valueOf(i + 1));
            print(dictionaryManagement.Dic.ListWord.get(i).word_target);
            print(dictionaryManagement.Dic.ListWord.get(i).word_explain);
            System.out.println();

        }
    }

    public void dictionaryBasic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1:   them tu");
        System.out.println("2:   xem tat ca tu");
        int i = sc.nextInt();
        if (i == 1) {
            dictionaryManagement.insertFromCommandline();
        } else {
            dictionaryManagement.insertFromFile();
            showAllWords();
        }
    }

    public boolean dictionaryAdvanced() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1:   nap tu");
        System.out.println("2:   xem tat ca tu");
        System.out.println("3:   tra cuu tu");
        int i = sc.nextInt();
        if(i==1){
            dictionaryManagement.insertFromFile();
        }
        else if(i==2){
            showAllWords();
        }
        else if(i==3){
            //dictionaryManagement.dictionaryLookup();
        }
        else {
            return false;
        }
        return true;
    }

    public void dictionarySearcher(){

    }

}
