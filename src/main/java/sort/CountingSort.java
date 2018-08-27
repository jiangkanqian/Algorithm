package sort;

import org.springframework.stereotype.Service;

/*
 *计数排序
 */
@Service("countingSort")
public class CountingSort implements ISort{
    @Override
    public void sort(int[] arr) {

        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int [] countArr = new int[max-min+1];
        for(int i=0;i<len;i++)
            countArr[arr[i] - min]++;
        int index = 0;
        for(int i=0;i<countArr.length;i++){
            while(countArr[i]-- > 0)
                arr[index++] = i + min;
        }

    }
}
