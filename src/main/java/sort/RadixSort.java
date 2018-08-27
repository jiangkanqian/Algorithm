package sort;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 *基数排序
 */
@Service("radixSort")
public class RadixSort implements ISort{

    @Override
    public void sort(int[] arr) {

        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] > max)
                max = arr[i];
        }
        int time = 0;
        //判断位数
        while(max > 0){
            max /= 10;
            time++;
        }
        //建立10个队列
        List<ArrayList> queue = new ArrayList<ArrayList>();
        for(int i=0;i<10;i++){
            ArrayList<Integer> queue1 = new ArrayList<Integer>();
            queue.add(queue1);
        }

        //进行time次分配和收集
        for(int i=0;i<time;i++){
            //分配数组元素
            for(int j=0;j<arr.length;j++){
                //得到数字的第time+1位数
                int x = arr[j] % (int) Math.pow(10,i+1) / (int) Math.pow(10,i);
                ArrayList<Integer> queue2 = queue.get(x);
                queue2.add(arr[j]);
                queue.set(x,queue2);
            }

            int index = 0;
            for(int k=0;k<10;k++){
                while(queue.get(k).size() > 0){
                    ArrayList<Integer> queue3 = queue.get(k);
                    arr[index++] = queue3.get(0);
                    queue3.remove(0);
                }
            }
        }

    }
}
