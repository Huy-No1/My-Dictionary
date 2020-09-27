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

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary Dic = new Dictionary();

    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong tu muon them");
        int n = sc.nextInt();
        String s = sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap tu tieng anh");
            String s1 = sc.nextLine();
            System.out.println("Nhap nghia tieng viet");
            String s2 = sc.nextLine();
            Word newWord = new Word(s1, s2);
            Dic.ListWord.add(newWord);
        }

    }

    public void insertFromFile() {
        try {
            //File s = new File("dictionaries.txt");
            Scanner scf = new Scanner(new BufferedReader(new FileReader("dictionaries.txt")));

            while (scf.hasNextLine()) {
                String s1 = scf.nextLine();
                int i= s1.indexOf("\t");
                Dic.ListWord.add(new Word(s1.substring(0,i), s1.substring(i+1, s1.length())));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String dictionaryLookup(String s) {
//        System.out.print("Nhap tu muon tra:");
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        for (int i = 0; i < Dic.ListWord.size(); i++) {
            if (s.equalsIgnoreCase(Dic.ListWord.get(i).word_target)) {
                System.out.print(Dic.ListWord.get(i).word_explain + "\n");
                return Dic.ListWord.get(i).word_explain;
            }
        }
        //if(!x) System.out.println("Khong tim thay");
        return "";
    }

    public String dictionaryLookup2(String s) {
//        System.out.print("Nhap tu muon tra:");
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        for (int i = 0; i < Dic.ListWord.size(); i++) {
            if (s.equalsIgnoreCase(Dic.ListWord.get(i).word_explain)) {
                System.out.print(Dic.ListWord.get(i).word_target + "\n");
                return Dic.ListWord.get(i).word_target;
            }
        }
        //if(!x) System.out.println("Khong tim thay");
        return "";
    }
    public void exporttofile() throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter pr = new PrintWriter("dictionaries.txt", "UTF-8")) {
            for(int i=0; i<this.Dic.ListWord.size(); i++)
                pr.println(this.Dic.ListWord.get(i).word_target+"\t"+this.Dic.ListWord.get(i).word_explain);
        }
    }

}
