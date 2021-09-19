/*
package com.itransition.training.task05.Users.alfa;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Rules {
    public static int countUser = 0;
    public static int countPC = 0;
    public static int draws = 0;

   static String playRound(int a, int b, String[] moves) {
       int num = moves.length;
       int num1;
       int num2;
       for (int i = 0; i < 128; i++) {
            System.out.println("Enter your move: " + (i + 1));

            if (a == b) {
                System.out.println("draw, your opponent select: " + moves[b] + "\n---------------");
                draws++;
                continue;
            } if (a - b > num / 2 || b - a > num / 2) {
                num1 = -a;
                num2 = -b;
            } else {
                num1 = a;
                num2 = b;
            }
            if (num1 > num2) {
                countPC++;
                System.out.println("You lose!");
            } else {
                countUser++;
                System.out.println("You win!");
            }
            System.out.println("You selected: " + a + ", Computer selected: " + b);
            System.out.println("---------------------------------------------");

        }
        System.out.println("score: " + countUser + " WINS | " + countPC + " LOSE | " + draws + " DRAWS");
         return "";
    }
}*/
/*package com.itransition.training.task05.Users.alfa;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Rules {
    static Scanner scanner = new Scanner(System.in);
    public static int countUser = 0;
    public static int countPC = 0;
    public static int draws = 0;
    public static String[] args;

    private static int[] sequence = RandomKey.getSequence();
    private static int num;

    Rules(int num, String[] args) {
        this.args = args;
        this.num = num;
        new RandomKey(this.num);
    }

    static String playRound() throws NoSuchAlgorithmException, InvalidKeyException {
        int numUser;
        int num1;
        int num2;
        System.out.println("Available moves:");
        for (int j = 0; j < num; j++) {
            System.out.println(j + 1 + " - " + args[j]);
        }
        System.out.print("HMAC: ");
        for (int i = 0; i < 128; i++) {
            new RandomKey(i, 1);
            System.out.println("Enter your move: " + (i + 1));

            numUser = scanner.nextInt();
            if (numUser == 911) {
                new TableHelp(num, args);
                i--;
                continue;
            }

            if (numUser == sequence[i]) {
                System.out.println("draw, Computer move: " + args[sequence[i] - 1]);
                System.out.println("HMAC key: " + RandomKey.getKey());
                System.out.println("---------------");
                System.out.print("HMAC: ");
                draws++;
                continue;
            } if (numUser - sequence[i] > num / 2 || sequence[i] - numUser > num / 2) {
                num1 = -num;
                num2 = -sequence[i];
            } else {
                num1 = num;
                num2 = sequence[i];
            }
            if (num1 > num2) {
                countPC++;
                System.out.println("You lose!");
            } else {
                countUser++;
                System.out.println("You win!");
            }
            System.out.println("You selected: " + args[numUser - 1] + ", Computer selected: " + args[sequence[i] - 1]);
            System.out.println("HMAC key: " + RandomKey.getKey());
            System.out.println("---------------------------------------------");
            System.out.print("HMAC: ");


        }
        System.out.println("score: " + countUser + " WINS | " + countPC + " LOSE | " + draws + " DRAWS");
        return "";
    }
}

 */