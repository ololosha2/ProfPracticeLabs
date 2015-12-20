package com.data.munging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Common {

    public static LinkedList<LinkedList<String>> readFromFile(String fileName) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            while (line != null) {
                LinkedList<String> array = new LinkedList<String>();
                for (String s: line.split(" ")){
                    if(!s.equals("")) {
                        array.add(s);
                    }
                }
                result.add(array);
                line = br.readLine();
            }
            result.remove(0);
        } catch (IOException exc) {
            System.err.println(exc);
        }
        return result;
    }

    public static String minDifference(LinkedList<LinkedList<String>> wholeList, int variant) {
        int column1, column2;
        String symbols;
        String returnValue = "";
        int minDif = 1000;
        int curDif;
        LinkedList<String> llist;
        int t1 = 0, t2 = 0;
        Iterator iter = wholeList.iterator();
        while (iter.hasNext()) {
            llist = (LinkedList<String>) iter.next();
            if (llist.size() != 0) {
                String s1 = "";
                String s2 = "";
                switch(variant) {
                    case 0:
                        column1 = 1;
                        column2 = 2;
                        symbols = "*";
                        s1 = llist.get(column1).replace(symbols, "");
                        s2 = llist.get(column2).replace(symbols, "");
                        break;
                    case 1:
                        column1 = 6;
                        column2 = 8;
                        if (llist.size() > 6) {
                            s1 = llist.get(column1);


                            s2 = llist.get(column2);
                        }
                        break;
                }
                if (!s1.equals("")) {
                    t1 = Integer.parseInt(s1);
                    t2 = Integer.parseInt(s2);
                }
                curDif = Math.abs(t1 - t2);
                if (curDif < minDif) {
                    minDif = curDif;
                    returnValue = llist.get(variant);
                }
            }
        }
        return returnValue;
    }
}
