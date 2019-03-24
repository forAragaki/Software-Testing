package softwareTest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class testPrime {
	private PrintPrimes pp;
	private int n;
	private int[] Prime;
	
	public testPrime(int n,int[] Prime){
		this.n = n;
		this.Prime = Prime;
	}
	@Before
	public void setUp(){
		pp = new PrintPrimes();
	
	}
	@Parameters
	public static Collection<Object[]>getData(){
		int[]a = new int[]{2};
		int[]b = new int[]{2,3};
		int[]c = new int[]{2,3,5};
		return Arrays.asList(new Object[][]{
			{1,a},
			{2,b},
			{3,c}
		});
	}
	@Test
	public void test(){
		int[] a = pp.printPrimes(n);
		for(int i=0;i<Prime.length;i++){
			assertEquals(Prime[i],a[i]);
		}
	}
}
