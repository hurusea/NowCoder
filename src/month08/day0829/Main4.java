package month08.day0829;

import java.util.Scanner;

/**
 * @hurusea
 * @create2020-08-29 15:51
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(10);
    }
}

//m,n=map(int,input().split())
//data = list(map(int,input().split()))
//result  = 0
//for i in range(1,m+1):
//    l=i
//    for j in range(l,m+1):
//        r=j
//        before = float('-inf')
//        flag = True
//        for k in range(len(data)):
//            x=data[k]
//            if(0<x and x<1) or (r<x and x<m+1):
//                if x>=before:
//                    bofore =x
//                else:
//                    flag = False
//                    break
//        if flag:
//            result +=1
//print(result)