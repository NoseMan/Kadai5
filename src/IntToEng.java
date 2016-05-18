import java.util.Scanner;

public class IntToEng {
	
	static final String[] oneToNine = {"one", "two", "three", "four", "five", "six", "seven"
			, "eight", "nine"};
	static final String[] twentyToNinety = {"twenty","thirty","fourty","fifty","sixty","seventy"
			,"eighty","ninety"}; 
	static final String[] tenToNineteen = {"ten","eleven","twelve","thirteen","fourteen","fifteen"
			,"sixteen","seventeen","eighteen","nineteen"};
	static final String[] largeUnit = {"thousand","million","billion","trillion","quadrillion"};
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
    	String s = String.valueOf(n);//nをStringに変換後桁数を3の倍数に補正
    	while(s.length() % 3 != 0){
    		s = "0"+s;
    	}
    	char[] nchar = s.toCharArray(); // sをchar[]に分割
    	for(int i = 0 ; i <= (nchar.length/2)-1 ; i++){//入れ替え
    		char a = nchar[i];
    		nchar[i] = nchar[nchar.length-1-i];
    		nchar[nchar.length-1-i] = a;
    	}
    	//for(int i=0;i<nchar.length;i++) System.out.print(nchar[i]+" "); // debug
    	for(int i=(nchar.length/3)-1;i>=0;i--){
    		boolean isZero = true; // 全部0か？
    		//System.out.println("iは" + i); // debug
    		for(int j=2;j>=0;j--){
    			//System.out.println("jは" + j); //debug
    			int charNum = Character.getNumericValue(nchar[j+(i*3)]);
    			if(charNum != 0){
    				//System.out.println("isZeroはおっけー nchar = "+ charNum); //debug
    				isZero = false;
    				if(j==0 && Character.getNumericValue(nchar[1+(i*3)])!=1 ) result.append(oneToNine[charNum-1]); // 1桁め
    				if(j==1){ // 2桁め
    					result.append(charNum==1 ? tenToNineteen[Character.getNumericValue(nchar[i*3])] : twentyToNinety[charNum-2]);//2桁め
    				}
    				if(j==2){
    					result.append(oneToNine[charNum-1] +  " hundred" );// 3桁め
    				}
    				result.append(" "); // 空白処理
    			}
    		}
    		if(!isZero && i != 0) result.append(largeUnit[i-1] + " " );
    	}
    	
        return result.deleteCharAt(result.lastIndexOf(" ")).toString();
    }
    
}
