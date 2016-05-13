import java.util.Scanner;

public class IntToEng {
	
	static final String[] oneToNine = {"one", "two", "three", "four", "five", "six", "seven"
			, "eight", "nine"};
	static final String[] twentyToNinety = {"twenty"}; // yoro
	
    // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(translateEng(input));

    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	String result = "";
    	
    	if(n==0) return "zero"; // 0の場合は例外としてzeroを返す
    	char[] nchar = String.valueOf(n).toCharArray(); // nをstringに変換後char[]に分割
    	for(int i=0;i>(nchar.length/3);i++){
    		for(int j=2;j>=0;j--){
    			if(j==1 && (int)nchar[1+i]!=1) result += translate1to9((int)nchar[j+i]); // 1桁め
    			if(j==2){ // 2桁め
    				result += ((int)nchar[j+i]!=1 ? /*10~19の場合のメソッド*/ : /*通常のメソッド*/);
    			}
    			if(j==3); // 3桁め
    		}
    	}
    	
        return result;
    }
    
    static String translate1to9(int one){ return oneToNine[one-1]; }
    static String translate20to90(int ten){ return twentyToNinety[ten-1]; }
}
