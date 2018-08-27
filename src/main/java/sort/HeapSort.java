package sort;

import org.springframework.stereotype.Service;

/*
 *堆排序
 */
@Service("heapSort")
public class HeapSort extends Sort implements ISort{

    public void sort(int[] arr) {

        int len = arr.length;
        for(int i=len/2-1;i>=0;i--){
            buildMaxHeap(arr,i,len-1);
        }
        for(int i=len-1;i>=1;i--){
            swap(arr,0,i);
            buildMaxHeap(arr,0,i-1);
        }

    }

    public void buildMaxHeap(int[] a,int i,int len){
        int left = 2*i+1;
        int right = 2*i+2;
        int largest;
        if(left <= len && a[left]>a[i])
            largest = left;
        else
            largest = i;
        if(right <= len && a[right] > a[largest])
            largest = right;
        if(largest != i){
            swap(a,i,largest);
            buildMaxHeap(a,largest,len);
        }
    }

}
