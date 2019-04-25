import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

public class testbp{
      private BackPack bb;
	  @Before
	  public void setUp()throws Exception{
		  bb = new BackPack();
	  }
	  @After
	  public void tp()throws Exception{
		  bb = null;
	  }
	  @Test
	  public void testbb(){
	      int m = 10;
	      int n = 3;
	      int w[] = {3, 4, 5};
	      int p[] = {4, 5, 6};
	      int[][]tr = {{0,0,4,4,4,4,4,4,4,4},
	    		  {0,0,4,5,5,5,9,9,9,9},	
	    		  {0,0,4,5,6,6,9,10,11,11}};
		  int[][] c = BackPack.BackPack_Solution(m,n,w,p);
		  for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= m; j++) {
	            	assertEquals(tr[i-1][j-1],c[i][j]);
	                }
	            }
	        }
		  
	  
}