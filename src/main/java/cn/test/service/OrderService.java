package cn.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.test.dao.OrderDAO;
import cn.test.domain.Order;

@Service
public class OrderService {

	@Autowired
	private OrderDAO orderDao;

	@Transactional
	public void insertOrder(Order order) {
		order.setOrderID(getNextId("ordernum"));
		orderDao.getAllOrder();
		orderDao.insertOrder(order);
	}

	private Integer getNextId(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
