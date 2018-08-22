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
        System.out.println("bubbleSort");
        int len = arr.length;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
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
