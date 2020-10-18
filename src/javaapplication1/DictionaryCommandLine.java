/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class DictionaryCommandLine {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void print(String s) {
        System.out.printf(s);
        for (int i = 0; i < 20 - s.length(); i++)
            System.out.printf(" ");
    }

    public void showAllWords() {

        System.out.println("No\t\t\t\t\tEnglish\t\t\t\tVietNamese");
        for (int i = 0; i < this.dictionaryManagement.a.size(); i++) {
            print(String.valueOf(i + 1));
            print(this.dictionaryManagement.a.get(i).word_target);
            print(this.dictionaryManagement.a.get(i).word_explain);
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
        } else if (i == 2) {
            //dictionaryManagement.insertFromFile();
            showAllWords();
        }
    }

    public boolean dictionaryAdvanced() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1:   nap tu");
        System.out.println("2:   xem tat ca tu");
        System.out.println("3:   tra cuu tu");
        int i = sc.nextInt();
        if (i == 1) {
            //dictionaryManagement.insertFromFile();
        } else if (i == 2) {
            showAllWords();
        } else if (i == 3) {
            System.out.println("Nhap tu muon tra: ");
            String s = sc.nextLine();
            dictionaryManagement.dictionaryLookup(s);
        } else {
            return false;
        }
        return true;
    }

    public void dictionarySearcher(String s) {

        for (int i = 0; i < this.dictionaryManagement.Dic.ListWord.size(); i++) {
            if (this.dictionaryManagement.a.get(i).word_target.toLowerCase().indexOf(s.toLowerCase()) == 0)
                System.out.println(this.dictionaryManagement.a.get(i).word_explain);
        }
    }


}
