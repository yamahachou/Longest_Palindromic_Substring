/**
 * Created by yamahachou on 2018/8/25.
 */
public class Solution {

    public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int MaxLen = 0;
        int MaxEnd = 0;
        for(int i = 0 ; i<s.length() ; i++){
            for(int j = 0;j <reverse.length(); j++){
                if(s.charAt(i) == reverse.charAt(j)){
                    if( i == 0 || j == 0){
                        arr[i][j] = 1;
                    }else{
                        arr[i][j] = arr[i -1][j - 1]+1;
                    }
                }
                if(arr[i][j] > MaxLen){
                    int beforePos = length - 1 - j;
                    int rightPos = beforePos + arr[i][j] - 1;
                    if(rightPos == i){
                        MaxLen = arr[i][j];
                        MaxEnd = i;
                    }
                }
            }
        }

        return s.substring(MaxEnd - MaxLen +1, MaxEnd+1);
    }

    public static void main(String[] args){

        String s = "babad";
        Solution solution = new Solution();
        String result = solution.longestPalindrome(s);
        System.out.println(result);

    }

}
