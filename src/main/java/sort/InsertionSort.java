package sort;

import org.springframework.stereotype.Service;


/*
 *插入排序
 */


@Service("insertionSort")
public class InsertionSort implements ISort{

    public void sort(int[] arr) {
        System.out.println("InsertionSort");
        int len = arr.length;
        for(int i=1;i<len;i++){
            int insertVal = arr[i];
            int index = i-1;
            while(index>=0 && insertVal<arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = insertVal;
        }
    }

}
