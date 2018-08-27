package sort;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 *桶排序
 */
@Service("bucketSort")
public class BucketSort implements ISort{

    public void sort(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }

        //创建桶
        int bucketNum = (max - min) /arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i=0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i=0;i<arr.length;i++){
            int num = (arr[i] - min)/(arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i=0;i<bucketArr.size();i++){
            Collections.sort(bucketArr.get(i));
        }

        //将桶中元素倒出
        int index = 0;
        for(int i=0;i<bucketArr.size();i++){
            if(bucketArr.get(i).size() > 0){
                for(int j=0;j<bucketArr.get(i).size();j++){
                    arr[index++] = bucketArr.get(i).get(j);
                }
            }
        }
    }
}
