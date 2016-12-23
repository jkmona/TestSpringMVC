package cn.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import org.hamcrest.core.CombinableMatcher;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

import cn.test.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/conf/spring/*.xml"})
@ContextConfiguration(locations={"file:src/main/resources/conf/spring/*.xml"})
public class BasicJunitSyntax {
	
	@Autowired
	private OrderService odService;
	
	@Before
    public void before(){            
		LinkedList mockedList = mock(LinkedList.class);
        //stubbing
        when(mockedList.get(0)).thenReturn("first");
    }
	
	@Test
    public void thisAlwaysPasses() {
		String abc = "abc";
		assertEquals("abc", abc);
    }
    @Test
    @Ignore
    public void thisIsIgnored() {
    	
    }
    @Test
	public void iterator_will_return_hello_world(){
		//arrange
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Hello").thenReturn("World");
		//act
		String result=i.next()+" "+i.next();
		//assert
		assertEquals("Hello World", result);
	}
    @Test
    public void testAssertFalse() {
      assertFalse("failure - should be false", false);
    }
   
    @Test
    public void testAssertNotNull() {
      assertNotNull("should not be null", new Object());
    }

    @Test
    public void testAssertNotSame() {
      assertNotSame("should not be same Object", new Object(), new Object());
    }

    @Test
    public void testAssertNull() {
      assertNull("should be null", null);
    }

    @Test
    public void testAssertSame() {
      Integer aNumber = Integer.valueOf(768);
      assertSame("should be same", aNumber, aNumber);
    }
    @Test
    public void testAssertThatHamcrestCoreMatchers() {
      assertThat("good", allOf(equalTo("good"), org.hamcrest.CoreMatchers.startsWith("good")));
      assertThat("good", not(allOf(equalTo("bad"), equalTo("good"))));
      assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
      assertThat(7, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
      assertThat(new Object(), not(sameInstance(new Object())));
    }

    @Test
    public void testAssertTrue() {
      assertTrue("failure - should be true", true);
    }
    
    @Test 
    public void filenameIncludesUsername() {
        assumeThat(File.separatorChar, is('/'));
        //assertThat(new User("optimus").configFileName(), is("configfiles/optimus.cfg"));
    }

    @Test 
    public void correctBehaviorWhenFilenameIsNull() {
       assumeTrue(true);  // bugFixed is not included in JUnit
       //assertThat(parse(null), is(new NullDocument()));
    }
    @Test(expected= IndexOutOfBoundsException.class) 
    public void empty() { 
         new java.util.ArrayList<Object>().get(0); 
    }
}
