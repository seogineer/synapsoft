package synapsoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    
    static HashMap<Character, String[][]> alphabets = new HashMap<Character, String[][]>();
    
    static void insertAlphabet(int n, String[][] arr) {
        if(n == 0) {
            alphabets.put('A', arr);
        } else if(n == 1) {
            alphabets.put('B', arr);
        } else if(n == 2) {
            alphabets.put('C', arr);
        } else if(n == 3) {
            alphabets.put('D', arr);
        } else if(n == 4) {
            alphabets.put('E', arr);
        } else if(n == 5) {
            alphabets.put('F', arr);
        } else if(n == 6) {
            alphabets.put('G', arr);
        } else if(n == 7) {
            alphabets.put('H', arr);
        } else if(n == 8) {
            alphabets.put('I', arr);
        } else if(n == 9) {
            alphabets.put('J', arr);
        } else if(n == 10) {
            alphabets.put('K', arr);
        } else if(n == 11) {
            alphabets.put('L', arr);
        } else if(n == 12) {
            alphabets.put('M', arr);
        } else if(n == 13) {
            alphabets.put('N', arr);
        } else if(n == 14) {
            alphabets.put('O', arr);
        } else if(n == 15) {
            alphabets.put('P', arr);
        } else if(n == 16) {
            alphabets.put('Q', arr);
        } else if(n == 17) {
            alphabets.put('R', arr);
        } else if(n == 18) {
            alphabets.put('S', arr);
        } else if(n == 19) {
            alphabets.put('T', arr);
        } else if(n == 20) {
            alphabets.put('U', arr);
        } else if(n == 21) {
            alphabets.put('V', arr);
        } else if(n == 22) {
            alphabets.put('W', arr);
        } else if(n == 23) {
            alphabets.put('X', arr);
        } else if(n == 24) {
            alphabets.put('Y', arr);
        } else if(n == 25) {
            alphabets.put('Z', arr);
        } else if(n == 26) {
            alphabets.put(' ', arr);
        }
    }
    
    public static void main(String[] args) {
        try {
            // 파일 읽어오기 - 시작
            String str;
            BufferedReader in = new BufferedReader(new FileReader("bitmap.txt"));
            ArrayList<String> list = new ArrayList<>();
            while ((str = in.readLine()) != null) {
                list.add(str);
            }
            in.close();
            // 파일 읽어오기 - 끝
            
            
            //파일에 있는 글자를 map에 추가 - 시작
            int start = 1;
            for(int n = 0; n < 26; n++) { // 총 26자
                String[][] alphabet = new String[7][6];
                int end = start + 6;
                int i = 0;
                for(int x = start; x <= end; x++) { // 알파벳 한 글자 배열에 저장
                    String bitmap = list.get(x);
                    for(int j = 0; j < 6; j++){
                        if((bitmap.charAt(j) - '0') == 1) {
                            alphabet[i][j] = "@";
                        } else if((bitmap.charAt(j) - '0') == 0) {
                            alphabet[i][j] = " ";
                        }
                    }
                    i++;
                }
                
                insertAlphabet(n, alphabet);
                
                start = start + 8;
            }
            
            //공백 추가 - 시작
            String[][] space = new String[7][6];
            for(int i = 0; i < 7; i++){
                for(int j = 0; j < 6; j++){
                    space[i][j] = " ";
                }
            }
            insertAlphabet(26, space);
            //공백 추가 - 끝
            
            //파일에 있는 글자를 map에 추가 - 끝
            
            
            //출력하고 싶은 글자 입력과 출력 - 시작
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine().toUpperCase();
            
            for(int k = 0; k < input.length(); k++) {
                char letter = input.charAt(k);
                String[][] result = alphabets.get(letter);
                for(int i = 0; i < 7; i++){
                    for(int j = 0; j < 6; j++){
                        System.out.print(result[i][j]);
                    }
                    System.out.println();
                }
            }
            //출력하고 싶은 글자 입력과 출력 - 끝
            
            
            //확대, 회전 - 시작
            for(int k = 0; k < input.length(); k++) {
                char letter = input.charAt(k);
                String[][] result = alphabets.get(letter);
                for(int i = 0; i < 12; i++){
                    for(int j = 0; j < 42; j++){
                        System.out.print(result[i][j]);
                    }
                    System.out.println();
                }
            }
            //확대, 회전 - 끝
            
            
            sc.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

}
