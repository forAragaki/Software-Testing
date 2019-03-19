package softwareTest;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.parameterized.TestWithParameters;
@RunWith(Parameterized.class)
public class Runwith {
	private Triangle tr;
	private int x;
	private boolean b;
	
	public Runwith(int x,boolean b){
		this.b = b;
		this.x = x;
	}
	
	@Before
	public void setUp(){
		tr = new Triangle();
	}
	@Parameters
	public static Collection<Object[]>getData(){
		return Arrays.asList(new Object[][]{
			{1,true},
			{2,true},
			{50,true},
			{100,false},
			{69,false},
			{-1,false}
		});
	}
	@Test
	public void test(){
		assertEquals(b,tr.judge(x));
	}

}
