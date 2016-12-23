package cn.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.test.domain.Order;

@Controller
public class HomeAction {
	private static final Logger _logger = LoggerFactory.getLogger(HomeAction.class);
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request){
//		_logger.error("someone access index.jsp");
		Order od = new Order();
		od.setOrderID(10001);
		od.setOrderNumber("000999");
		request.getSession().setAttribute("MyOrder", od);
		request.getSession().setAttribute("TNumber", 1);
		request.getSession().setAttribute("TString", "abc");
//		HashMap<String,String> hm = new HashMap<String,String>();
//		hm.put("test","21345");
//		hm.put("test2","123124");
//		request.setAttribute("versionMap", hm);
		_logger.info("success");
	    return "index";
	}
}
