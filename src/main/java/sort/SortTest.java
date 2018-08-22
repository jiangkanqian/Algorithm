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
    @Qualifier("bubbleSort")
    private ISort bubbleSort;

    public static void main(String[] args){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        SortTest sortTest = app.getBean(SortTest.class);
        sortTest.testSort();
    }

    @Test
    public void testSort(){
        int arr[] = {5,8,2,7,6,4,3,1};
        bubbleSort.sort(arr);
    }

}
