package sort;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
*冒泡排序
 */

@Service("bubbleSort")
public class BubbleSort implements ISort{

    public void sort(int[] arr){
        System.out.println("bubbleSort:");
        int len = arr.length;
        /*
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        */
        for(int i=0;i<len;i++){
            for(int j=1;j<len-i;j++){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
            }
        }


    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
