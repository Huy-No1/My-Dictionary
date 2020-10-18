/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 * @author Admin
 */

import java.io.*;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryManagement {
    ArrayList<Word> a = new ArrayList<>();
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
            Word newWord = new Word(s1, "", s2);
            Dic.ListWord.add(newWord);
        }
    }

    public void insertFromFile() throws Exception {
//        try {
//            //File s = new File("dictionaries.txt");
//            Scanner scf = new Scanner(new BufferedReader(new FileReader("output.txt")));
//            while (scf.hasNextLine()) {
//                String s1 = scf.nextLine();
//                int i = s1.indexOf("\t");
//                int j = s1.lastIndexOf("\t");
//                Word t = new Word(s1.substring(0, i), s1.substring(i + 1, j), s1.substring(j + 1, s1.length()));
//                this.Dic.ListWord.add(t);
//            }
//            a = new ArrayList<>(this.Dic.ListWord);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Connection connection = Connectionsql.getJDBCConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM tbl_edict");
        while (rs.next()) {
            String tar = rs.getString("word_target");
            String pro = rs.getString("pronounce");
            String expl = rs.getString("word_explain");
            Dic.ListWord.add(new Word(tar, pro, expl));
        }
        a = new ArrayList<>(this.Dic.ListWord);
    }

    public Word dictionaryLookup(String s) {
        a = new ArrayList<>(this.Dic.ListWord);
        ComparaTo comparaTo = new ComparaTo();
        int index = Collections.binarySearch(a, new Word(s, null, null), comparaTo);
        if (index < 0)
            return new Word("","","");
        else
            return a.get(index);
    }

    public void setWordDictionaryLookup(String s, String explain) {
        a = new ArrayList<>(this.Dic.ListWord);
        ComparaTo comparaTo = new ComparaTo();
        int index = Collections.binarySearch(a, new Word(s, null, null), comparaTo);
        if (index < 0)
            return;
        else
            a.get(index).word_explain = explain;
    }

    public void exporttofile() throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter pr = new PrintWriter("dictionaries.txt", "UTF-8")) {
            for (Word s : this.Dic.ListWord) {
                //System.out.println(s);
                pr.println(s.toString());
            }
        }
    }

}
