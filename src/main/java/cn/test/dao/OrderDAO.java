package cn.test.dao;

import java.util.List;

import cn.test.domain.Order;

public interface OrderDAO {
	List<Order> getAllOrder();
	int insertOrder(Order order);
}
