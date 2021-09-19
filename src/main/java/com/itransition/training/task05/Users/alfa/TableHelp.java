package com.itransition.training.task05.Users.alfa;

public class TableHelp {
    public static String a;

    public TableHelp(int num, String[] args) {
        int im, jm;
        this.a = String.format(" \\   User\nPC \\       ");
        for (int  i = 0; i < num; i++) a += String.format("| %-10s " ,args[i]);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num + 1; j++) {
                if (j == 0) {
                    a += "\n";
                    a += "-----------";
                    for (int k = 0; k < num; k++) {
                        a += "------------";
                    }
                    a += "\n";
                        a += String.format("%-10s " ,args[i]);
                    continue;
                }
                else {
                    if (i + 1 == j) {
                        a += String.format("| %-10s ", "draw");
                        continue;
                    } if (i - j > num / 2 || j - i > num / 2) {
                        im = -i;
                        jm = -j;
                    } else {
                        im = i;
                        jm = j;
                    }
                    if (im > jm) {
                        a += String.format("| %-10s ", "lose");
                    } else {
                        a += String.format("| %-10s ", "win");
                    }
                }
            }
        }
    }
}
