package sort;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import org.junit.Test;

@Component
public class SortTest {

    @Autowired
    @Qualifier("radixSort")
    private ISort sortMethod;

    public static void main(String[] args){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        SortTest sortTest = app.getBean(SortTest.class);
        sortTest.testSort();
    }

    @Test
    public void testSort(){
        int arr[] = {12,20,5,16,15,1,30,20,45,23,9};
        sortMethod.sort(arr);
        print(arr);
    }

    public void print(int a[]){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i] + "  ");
        }
    }

}
