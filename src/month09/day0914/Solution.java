package month09.day0914;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @hurusea
 * @create2020-09-14 16:52
 */
public class Solution {
//    static boolean foo(char c) {
//        System.out.print(c);
//        return true;
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(isValid(s));
    }

    public static String removeRepeatedChar(String str) {
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int first = str.indexOf(c);
            int last = str.lastIndexOf(c);
            if (last == first || first == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static  boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{') {
                stack.push(s.charAt(i));
            }else {
                char temp = s.charAt(i);
                if (temp==' ') continue;
                if(stack.isEmpty()) return false;
                if(temp==')'&&stack.pop()!='(') return false;
                if(temp==']'&&stack.pop()!='[') return false;
                if(temp=='}'&&stack.pop()!='{') return false;
            }
        }
        return stack.isEmpty();
    }
}
