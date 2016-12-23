package cn.test.controller;

import java.util.Date;


import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.test.dao.OrderDAO;
import cn.test.domain.Order;

@Controller
public class OrderAction {
	@Autowired
	private OrderDAO orderService;
	
	@ResponseBody
	@RequestMapping("/order/addOrder")  // 请求url地址映射，类似Struts的action-mapping
    public String addOrder(HttpServletRequest request) {
		Order od = new Order();
		String orderNumber = request.getParameter("orderNumber");
		od.setOrderNumber(orderNumber);
		od.setOrderID(new Date().getTime());
		orderService.insertOrder(od);
        return String.valueOf(od.getOrderID());
    }
	@ResponseBody
	@RequestMapping("/order/getOrder")  // 请求url地址映射，类似Struts的action-mapping
    public String getOrder(HttpServletRequest request) {
		//List<Order> oList = orderService.getAllOrder();
		//JSONArray ja = JSONArray.fromObject(oList);
		Order od = (Order)request.getSession().getAttribute("MyOrder");
		//int tNumber = (Integer)request.getSession().getAttribute("TNumber");
		//String tString = (String)request.getSession().getAttribute("TString");
		JSONArray ja = JSONArray.fromObject(od);

        return ja.toString();
    }
}
