package sort;

import org.springframework.stereotype.Service;

/*
 *快速排序
 */
@Service("quickSort")
public class QuickSort implements ISort{

    public void sort(int[] arr) {
        System.out.println("quickSort:");
        int len = arr.length;
        quickSort(arr,0,len-1);
    }

    public void quickSort(int[] a,int start,int end){
        if(start > end){
            return;
        }

        int key = a[start];
        int i = start;
        int j = end;
        while (i<j){
            while(i<j && a[j] > key)
                j--;
            swap(a,i,j);
            while(i<j && a[i] < key)
                i++;
            swap(a,j,i);
        }
        a[i] = key;

        quickSort(a,start,i-1);
        quickSort(a,i+1,end);
    }

    public void quickSort1(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(start < end){
            while(start < end && a[end] >= key)
                end--;
            swap(a,start,end);
            while(start < end && a[start] <= key)
                start++;
            swap(a,end,start);
        }
        if(start > low)
            quickSort1(a,low,start-1);
        if(end < high)
            quickSort1(a,end+1,high);
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
