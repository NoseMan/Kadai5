import java.util.Scanner;

public class IntToEng {
	
	static final String[] oneToNine = {"one", "two", "three", "four", "five", "six", "seven"
			, "eight", "nine"};
	static final String[] twentyToNinety = {"twenty","thirty","fourty","fifty","sixty","seventy"
			,"eighty","ninety"}; 
	static final String[] tenToNineteen = {"ten","eleven","twelve","thirteen","fourteen","fifteen"
			,"sixteen","seventeen","eighteen","nineteen"};
    // メインメソッド
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(translateEng(input));

    }

    // 数値を英訳する変換するメソッド
    static String translateEng(int n) {
    	StringBuilder result = new StringBuilder();
    	
    	if(n==0) return "zero"; // 0の場合は例外としてzeroを返す
    	char[] nchar = String.valueOf(n).toCharArray(); // nをstringに変換後char[]に分割
    	for(int i=0;i<nchar.length;i++) System.out.print(nchar[i]+" "); // debug
    	boolean isZero = true; //全部0か？
    	for(int i=(nchar.length/3)-1;i>=0;i--){
    		System.out.println("iは" + i);
    		for(int j=2;j>=0;j--){
    			System.out.println("jは" + j);
    			int charNum = Character.getNumericValue(nchar[j+(i*3)]);
    			if(charNum != 0){
    				System.out.println("isZeroはおっけー nchar = "+ charNum);
    				isZero = false;
    				if(j==0 && Character.getNumericValue(nchar[1+(i*3)])!=1 ) result.append(translate1to9(charNum)); // 1桁め
    				if(j==1){ // 2桁め
    					result.append(charNum==1 ? translate10to19(Character.getNumericValue(nchar[i*3])) : translate20to90(charNum));//2桁め
    				}
    				if(j==2){
    					result.append(translate1to9(charNum) +  "hundred");// 3桁め
    				}	
    			}
    		}
    	}
    	
        return result.toString();
    }
    
    static String translate1to9(int n){ System.out.println("translate1to9 throw n="+n); return oneToNine[n-1]; }
    static String translate20to90(int n){ System.out.println("translate20to90 throw n="+n); return twentyToNinety[n-1]; }
    static String translate10to19(int n){ System.out.println("translate10to19 throw n="+n); return tenToNineteen[n]; }
}
