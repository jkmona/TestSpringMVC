
package cn.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.LinkedList;

import javax.annotation.Resource;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerMapping;

//import org.springframework.test.web.servlet.MockMvc;  

import org.springframework.web.servlet.ModelAndView;

import cn.test.controller.*;
import cn.test.domain.Order;
import cn.test.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/test/resources/conf/spring/*.xml"})
public class TestOrderServlet {
	//private OrderAction orderAction;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    
    @Autowired 
    @InjectMocks
    private OrderAction orderAction;
    
    // Create an instance of what you are going to test.
    // When using the @InjectMocks annotation, you must create the instance in
    // the constructor or in the field declaration.
    //@InjectMocks
    //public OrderAction orderAction = new OrderAction();

    // The @Mock annotation creates the mock instance of the class and
    // automatically injects into the object annotated with @InjectMocks (if
    // possible).
    @Mock
    private OrderService orderService;
    
    // This @Mock annotation simply creates a mock instance. There is nowhere to
    // inject it. Depending on the particular circumstance, it may be better or
    // clearer to instantiate the mock explicitly in the test itself, but we're
    // doing it here for illustration. Also, I don't know what your real class
    // is like, but it may be more appropriate to just instantiate a real one
    // than a mock one.
    @Mock
    private ModelMap model;
    
    //private MockMvc mockMvc;
    
	private Order order;
    
    @Before
    public void setUp() {
        //servlet = new MyServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        request.setContentType(MediaType.APPLICATION_JSON.toString());
        request.setAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE, Boolean.FALSE);
        //request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);

        MockitoAnnotations.initMocks(TestOrderServlet.class);
    }
    @Test
    public void testAddOpinion1() {
        //Foo foo = new Foo(1L);
        //when(mockFooDAO.findById(foo.getId()).thenReturn(foo);
        
    	request.setRequestURI("/order/addOrder");
        request.setMethod("POST");
        request.setParameter("orderNumber", "od123456");
        
        try{
           	String a = orderAction.addOrder(request);
            System.out.println(" = " + a);
        }catch (Exception e){
            e.printStackTrace();
        }
    	//orderService.insertOrder(new Order());;
    	System.out.println(1);
	}
}
