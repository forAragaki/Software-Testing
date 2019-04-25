import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class testbubble{
      private BubbleSort bb;
	  @Before
	  public void setUp()throws Exception{
		  bb = new BubbleSort();
	  }
	  @After
	  public void bbafter()throws Exception{
		  bb = null;
	  }
	  @Test
	  public void testbb(){
		  int[] arr = new int[]{ 1,2,0,4,6 };
		  int[] tr_arr = new int[]{ 0,1,2,4,6 };
		  int[] a = BubbleSort.BubbleSort(arr);
		  for(int i=0;i<arr.length;i++){
			  assertEquals(tr_arr[i],a[i]);
		  }
	  }
}