package com.sqli.train;

import java.util.ArrayList;
import java.util.List;

public class Train {
    private List<String> wagons;

    public Train(String structure) {
        wagons = new ArrayList<>();
        for (int i = 0; i < structure.length(); i++) {
            char c = structure.charAt(i);
            if (c == 'H') {
                if (i == 0) {
                    wagons.add("<HHHH");
                } else if (i	 == structure.length() - 1) {
                    wagons.add("HHHH>");
                }
            } else if (c == 'P') {
                wagons.add("|OOOO|");
            } else if (c == 'R') {
                wagons.add("|hThT|");
            } else if (c == 'C') {
                wagons.add("|____|");
            }
        }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wagons.size(); i++) {
            sb.append(wagons.get(i));
            if (i < wagons.size() - 1) {
                sb.append("::");
            }
        }
        return sb.toString();
    }

    public void detachEnd() {
        if (!wagons.isEmpty()) {
            wagons.remove(wagons.size() - 1);
        }
    }

    public void detachHead() {
        if (!wagons.isEmpty()) {
            wagons.remove(0);
        }
    }

    public boolean fill() {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i).equals("|____|")) {
                wagons.set(i, "|^^^^|");
                return true;
            }
        }
        return false;
    }
}
