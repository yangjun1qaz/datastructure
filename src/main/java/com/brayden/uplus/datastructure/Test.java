package com.brayden.uplus.datastructure;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/6/30
 */
public class Test {
    public static void main(String[] args) {
        int[] ss={-2,1,-3,4,-1,2,1,-5,4};
        int test = test(ss);
        System.out.println(test);

    }

    private static int test(int[] ss){
        int result=0;
        for(int i=0;i<ss.length;i++){
            for(int j=i+1;j<ss.length;j++){
                int temp=0;
                for(int k=i;k<=j;k++){
                    temp+=ss[k];
                }
                if(temp>result){
                    result=temp;
                }
            }
        }
        return result;
    }
}
