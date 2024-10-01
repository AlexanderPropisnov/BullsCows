package bullscows;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try {
            System.out.println("Input the length of the secret code:");
            int x = reader.nextInt();

            System.out.println("Input the number of possible symbols in the code:");
            int z = reader.nextInt();

            if (z<x){
                System.out.println("Error: it's not possible to generate a code with this number of unique symbols.");
            } else if ((x > 36) || (z > 36) || (x <=0)){
                System.out.println("Error: can't generate a secret number");
            }
            else {
                System.out.print("The secret is prepared: ");

                for (int i = 0; i < x; i++){
                    System.out.print("*");
                }

                if (z<=10){
                    if (z > 0){
                        System.out.print(" (0-");
                        System.out.print((char)(z+47));
                        System.out.println(").");
                    }
                    else{
                        System.out.println(".");
                    }
                }
                else{
                    System.out.print(" (0-9, a");
                    if (z>11){
                        System.out.print("-");
                        System.out.print((char)(z+86));
                        System.out.println(").");
                    }
                    else{
                        System.out.println(").");
                    }

                }


                System.out.println("Okay, let's start a game!");


                int bulls = 0;
                int cows;
                int turn = 1;

                int[] Pat = new int[x];

                String temp;
                int temp2;
                Random random = new Random();

                int[] Code = new int[x];
                char[] Code2 = new char[x];
                int count = 0;
                boolean check = false;
                int diff = 0;
                if (z > 10){
                    diff = z - 10;
                }


                while (count < x){
                    if (z > 10){
                        temp2 = random.nextInt(diff+97);
                    }
                    else {
                        if (z == 0) {
                            temp2 = 48;
                        } else {
                            temp2 = random.nextInt(z) + 48;
                        }
                    }
                    if (((temp2 >= 48) && (temp2 <= 57)) || ((temp2 >= 97) && (temp2 <= 123))) {
                        if (count == 0) {
                            Code[count] = temp2;
                            Code2[count] = (char) temp2;
                            count++;

                        } else {
                            for (int i = 0; i < count; i++) {
                                if (temp2 == Code[i]) {
                                    check = true;
                                }
                            }
                            if (check == false) {
                                Code[count] = temp2;
                                Code2[count] = (char) temp2;
                                count++;
                            } else {
                                check = false;
                            }
                        }
                    }
                }
/*
            for (int i = 0; i < x; i++) {
                System.out.print(Code2[i]);
            }

            System.out.println();
*/

                while(bulls != x) {

                    bulls = 0;
                    cows = 0;

                    System.out.println("Turn "+ turn+":");

                    temp = reader.next();

                    for (int i = 0; i < x; i++) {
                        Pat[i] = temp.charAt(i);
                    }


                    for (int i = 0; i < x; i++) {
                        for (int j = 0; j < x; j++) {
                            if ((Code[j] == Pat[i]) && (i == j)) {
                                bulls++;
                            } else if ((Code[j] == Pat[i]) && (i != j)) {
                                cows++;
                            }
                        }
                    }


                    System.out.print("Grade: ");
                    System.out.print(bulls);
                    System.out.print(" bull and ");
                    System.out.print(cows);
                    System.out.println(" cow");
                    turn++;
                }
                System.out.println("Congratulations! You guessed the secret code.");

                reader.close();
            }

        } catch (Exception e){
            System.out.println("Error: isn't a valid number.");
        }
    }
}