package sort;

import org.springframework.stereotype.Service;

/*
 *归并排序
 */
@Service("mergeSort")
public class MergeSort implements ISort{

    public void sort(int[] arr) {
        System.out.println("mergeSort:");
        mergeSort(arr,0,arr.length-1);
    }

    public void mergeSort(int[] a,int left,int right){
        if(left < right){
            int mid = (right + left)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }

    public void merge(int[] a,int left,int mid,int right){
        int[] tmpArr = new int[right-left+1];
        int leftIndex = left;
        int rightIndex = mid+1;
        int tmpIndex = 0;
        while(leftIndex<=mid && rightIndex<=right){
            if(a[leftIndex] <= a[rightIndex]){
                tmpArr[tmpIndex++] = a[leftIndex++];
            }
            else{
                tmpArr[tmpIndex++] = a[rightIndex++];
            }
        }
        while(leftIndex <= mid){
            tmpArr[tmpIndex++] = a[leftIndex++];
        }
        while(rightIndex <= right){
            tmpArr[tmpIndex++] = a[rightIndex++];
        }

        for(int i=0;i<tmpArr.length;i++){
            a[left++] = tmpArr[i];
        }
    }

}
