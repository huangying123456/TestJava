import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


public class Main
{
    public static void findSubArray(int[] arr){
        if(arr == null || arr.length == -1){
            System.out.println("数组为空或者没有元素");
        }
        int size = 1;
        int location = 0;
        int tempSize = 0;
        int tempLocation = 0;
        for(int i = 0 ;  i < arr.length - 1 ; i ++){
            if((arr[i] + 1) == arr[i + 1]){
                System.out.println("ifzhong" + arr[i]);
                tempSize ++;
            }else{
                System.out.println("else" + size +" "+location);
                if(tempSize > size){
                    size = tempSize;
                    location = tempLocation;
                }
                tempLocation = i + 1;
                tempSize = 1;
            }

            if(tempSize > size){
                size = tempSize;
                location = tempLocation;
            }
        }



    }

    public static void main(String args[])
    {
        int[] a = new int[]{1,3,4,5,6,9,10};
        findSubArray(a);
    }
}