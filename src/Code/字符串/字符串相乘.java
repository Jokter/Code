package Code.字符串;

import com.sun.org.apache.bcel.internal.generic.DMUL;

public class 字符串相乘 {

    public static void main(String[] args) {
        System.out.println(multiply("123", "123"));
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length()-1;
        int len2 = num2.length()-1;
        if(len1<0||len2<0){
            return "";
        }
        int[] mul = new int[len1+len2+2];
        for(int i = len1;i>=0;i--){
            for(int j = len2;j>=0;j--){
                int temp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+mul[i+j+1];
                mul[i+j+1] = temp%10;
                mul[i+j] = mul[i+j]+temp/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index<mul.length-1&&mul[index]==0){
            index++;
        }
        for(int k = index;k<mul.length;k++){
            sb.append(mul[k]);
        }
        return sb.toString();
    }

}
