package synapsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test { 
    
    static HashMap<Character, String[][]> alphabetList = new HashMap<Character, String[][]>();
    static ArrayList<String> list = new ArrayList<>();
    static String[][] alphabet;
    static String[][] rotatedAlphabet;
    
    static void insertAlphabet(int n, String[][] arr) {
        if(n == 0) {alphabetList.put('A', arr);}
        else if(n == 1) {alphabetList.put('B', arr);}
        else if(n == 2) {alphabetList.put('C', arr);}
        else if(n == 3) {alphabetList.put('D', arr);}
        else if(n == 4) {alphabetList.put('E', arr);}
        else if(n == 5) {alphabetList.put('F', arr);}
        else if(n == 6) {alphabetList.put('G', arr);}
        else if(n == 7) {alphabetList.put('H', arr);}
        else if(n == 8) {alphabetList.put('I', arr);}
        else if(n == 9) {alphabetList.put('J', arr);}
        else if(n == 10) {alphabetList.put('K', arr);}
        else if(n == 11) {alphabetList.put('L', arr);}
        else if(n == 12) {alphabetList.put('M', arr);}
        else if(n == 13) {alphabetList.put('N', arr);}
        else if(n == 14) {alphabetList.put('O', arr);}
        else if(n == 15) {alphabetList.put('P', arr);}
        else if(n == 16) {alphabetList.put('Q', arr);}
        else if(n == 17) {alphabetList.put('R', arr);}
        else if(n == 18) {alphabetList.put('S', arr);}
        else if(n == 19) {alphabetList.put('T', arr);}
        else if(n == 20) {alphabetList.put('U', arr);}
        else if(n == 21) {alphabetList.put('V', arr);}
        else if(n == 22) {alphabetList.put('W', arr);}
        else if(n == 23) {alphabetList.put('X', arr);}
        else if(n == 24) {alphabetList.put('Y', arr);}
        else if(n == 25) {alphabetList.put('Z', arr);}
        else if(n == 26) {alphabetList.put(' ', arr);}
    }
    
    static void expandAlphabet() {
        int start = 1;
        for(int letterNumber = 0; letterNumber < 26; letterNumber++) { // 총 26자
            alphabet = new String[42][12];
            int end = start + 6;
            int y = 0;
            for(int indexLine = start; indexLine <= end; indexLine++) { // 알파벳 한 글자를 배열에 저장
                int x = 0;
                String bitmap = list.get(indexLine);
                for(int col = 0; col < 6; col++){
                    if((bitmap.charAt(col) - '0') == 1) {
                        for(int n = y; n < (y + 6); n++) {
                            for(int m = x; m < (x + 2); m++) {
                                alphabet[n][m] = "@";
                            }
                        }
                        x = x + 2;
                    } else if((bitmap.charAt(col) - '0') == 0) {
                        for(int n = y; n < (y + 6); n++) {
                            for(int m = x; m < (x + 2); m++) {
                                alphabet[n][m] = " ";
                            }
                        }
                        x = x + 2;
                    }
                }
                y = y + 6;
            }
            
            rotatedAlphabet = new String[12][42];
            rotationAlphabet();
            
            insertAlphabet(letterNumber, rotatedAlphabet);
            start = start + 8;
        }
        
        String[][] space = new String[12][42];
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 42; j++){
                space[i][j] = " ";
            }
        }
        insertAlphabet(26, space);
    }
    
    static void rotationAlphabet() {
        int m = 41;
        for(int i = 0; i < 42; i++) {
            int n = 0;
            for(int j = 0; j < 12; j++) {
                rotatedAlphabet[n][m] = alphabet[i][j];
                n++;
            }
            m--;
        }
    }
    
    public static void main(String[] args) {
        try {
            String str;
            BufferedReader in = new BufferedReader(new FileReader("bitmap.txt"));
            while ((str = in.readLine()) != null) {
                list.add(str);
            }
            in.close();
            
            expandAlphabet();
            
            // 문장 입력과 출력 - 시작 
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().toUpperCase();
            
            for(int k = 0; k < input.length(); k++) {
                char letter = input.charAt(k);
                String[][] result = alphabetList.get(letter);
                for(int i = 0; i < 12; i++){
                    for(int j = 0; j < 42; j++){
                        System.out.print(result[i][j]);
                    }
                    System.out.println();
                }
            }
            // 문장 입력과 출력- 끝
            
            sc.close();
        } catch (Exception e) {
            
        }
    }
}
