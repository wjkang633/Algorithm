package study.algorithm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Main T = new Main();

        Scanner in=new Scanner(System.in);
        String str = in.next();
        String target = in.next();

        for (int a: T.solution10(str, target)){
            System.out.println(a + " ");
        }
    }

    //7. 회문 문자열
    public String solution7(String str){
        //1) StringBuilder의 reverse() 사용
        /*
        StringBuilder sb = new StringBuilder(str);

        if (sb.reverse().toString().equalsIgnoreCase(str)) return "YES";
        else return "NO";
         */

        //2) 문자열 길이 절반만큼 비교하기
        str = str.toUpperCase();

        for (int i=0;i<str.length()/2;i++){
            if (str.charAt(i) != str.charAt(str.length()-i-1)) return "NO";
        }

        return "YES";
    }

    //8. 유효한 팰린드룸
    public String solution8(String str){
        //1) 내 코드
        /*
        str = str.toUpperCase();

        int lt =0;
        int rt = str.length()-1;

        while(lt<rt){
            if (!Character.isAlphabetic(str.charAt(lt))) lt++;
            else if (!Character.isAlphabetic(str.charAt(rt))) rt--;
            else
            {
                if(str.charAt(lt) != str.charAt(rt)) return "NO";

                lt++;
                rt--;
            }
        }

        return "YES";
         */

        //2) (ReplaceAll + 정규식 사용)
        str = str.toUpperCase();
        str = str.replaceAll("[^A-Z]", "");

        String tmp = new StringBuilder(str).reverse().toString();

        if (tmp.equals(str)) return "YES";
        else return "NO";
    }

    //9. 숫자만 추출
    public int solution9(String str){
        //1) 내 코드(replaceAll 사용)
        /*
        str = str.replaceAll("[^0-9]","");

        int i = 0;

        for (;i<str.length();i++){
            if (str.charAt(i) != '0') break;
        }

        return str.substring(i);
        */

        //2) 아스키 코드 사용
        /*
        int ans = 0;

        char arr[] = str.toCharArray();

        for(int i=0 ; i < arr.length ; i++){
            if (arr[i] >= 48 && arr[i]<= 57) //0~9
                ans = ans * 10 + (arr[i] -  48);
        }

        return String.valueOf(ans);
        */

        //3) ParseInt 사용
        String ans  = "";

        for (char x : str.toCharArray()){
            if (Character.isDigit(x)) ans += x;
        }

        return Integer.parseInt(ans);
    }

    //10. 가장 짧은 문자 거리
    public int[] solution10(String str, String target){
        int result[] = new int[str.length()];

        int pos = 101;

        //우방향으로 1차 검사
        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == target.charAt(0)) {
                pos = 0;
                result[i] = pos;
            }
            else{
                pos ++;
                result[i] = pos;
            }
        }

        pos = 101;

        //좌방향으로 2차 검사
        for (int i=str.length()-1;i>=0;i--){
            if (str.charAt(i) == target.charAt(0)) {
                pos = 0;
            }
            else{
                pos ++;

                result[i] = Math.min(result[i], pos);
            }
        }

        return result;
    }
}
