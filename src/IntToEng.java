import java.util.Scanner;

public class IntToEng {
    // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(translateEng(input));

    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	String eng;
    	int len = String.valueOf(n).length();
    	int d = (int)Math.pow(10, len-1);
    	if(n == 0){
    		return "zero";
    	}
    	
    	}
        return eng;
    }
}
