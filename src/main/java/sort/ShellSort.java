package sort;


import org.springframework.stereotype.Service;

/*
 *希尔排序
 */
@Service("shellSort")
public class ShellSort extends Sort implements ISort{

    public void sort(int[] arr) {
        System.out.println("shellSort:");
        int len = arr.length;
        int feet = len/2;
        int index;
        while(feet >= 1){
            for(int i=feet;i<len;i++){
                index = i;
                while(index >= feet){
                    if(arr[index-feet] > arr[index]){
                        swap(arr,index-feet,index);
                        index -= feet;
                    }
                    else
                        break;
                }
            }
            feet /= 2;
        }
    }


}
