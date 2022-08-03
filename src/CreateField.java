import java.awt.*;
import java.util.PrimitiveIterator;
import java.util.Scanner;
public class CreateField {
    static Scanner scanner = new Scanner(System.in);
     static char [][] chars = new char[9][9];
     static char[][] chars1 = new char[9][9];
     static int numberOfBreak = 0;

    public static void create(){
        char [] alphabet = {'A','B','C','D','I','F','J','K','D'};
        for (int i = 1; i< chars.length; i++) {
            for(int j = 1; j< chars[0].length; j++){
                chars [i][j] = '.';
                chars1[i][j] = '*';
            }
        }
        for (int i=0; i< chars.length-1;i++){
            String string = String.valueOf(i);
            char ch = string.charAt(0);
            chars[i][0] = ch;
            chars[0][i+1] = alphabet[i];
            chars[8][0] = '8';
            chars[0][0] ='=';
            chars1[i][0] = ch;
            chars1[0][i+1] = alphabet[i];
            chars1[8][0] = '8';
            chars1[0][0] ='=';
        }
        for (int i = 1;i<5;i++) {
            chars1[3][i] = '#';
            chars1[i][7] = '#';
            chars1[7][i] = '#';
        }
        chars1[1][7] = '*';chars1[1][2] = '#';
        chars1[7][1] = '*';chars1[1][3] = '#';
        chars1[6][1] = '#';chars1[7][8] = '#';
        chars1[5][2] = '#';chars1[7][7] = '#';
        chars1[5][6] = '#';chars1[5][3] = '#';
        chars1[1][6] = '#';chars1[2][5] = '#';

    }

    public static void batl (){
        for (int i =0;i<64;i++) {
            String s = scanner.next();
            int y =scanner(s);
            int x =scanner.nextInt();
            chars[x][y] = chars1[x][y];
            numberOfBreak= print(chars);
            if (numberOfBreak >=20){
                System.out.println("You are win");
                print(chars1);
            }
        }
    }
    public static int scanner(String s){
        int z = 0;
        switch (s){
            case "A": z = 1;
            break;
            case "B": z = 2;
            break;
            case "C": z = 3;
            break;
            case "D": z = 4;
                break;
            case "I": z = 5;
                break;
            case "F": z = 6;
                break;
            case "J": z = 7;
                break;
            case "K": z = 8;
                break;
            default:
                throw new IllegalArgumentException("Unexpected value :"+ s);
        } return z;
    }

    public static int print (char chars[][]) {
        int n = 0;
        for (int i = 0; i< chars.length; i++) {
            for(int j = 0; j< chars[0].length; j++) {
                System.out.print(chars[i][j]+ "  ");
                if (chars[i][j] == '#' ){
                    n++;
                }
            }
            System.out.println();
        }
        return n;
    }
}

