package com.order.model;

import java.util.List;


public interface OrderDAO_interface {
	public void insert(OrderVO orderVO);
	public void update(OrderVO orderVO);
	public OrderVO findByPrimaryKey(Integer orderNumber);
	public List<OrderVO> getAll();
	public List<OrderVO> findByUserNumber(Integer userNumber);
	public List<OrderVO> getUserNumber();
	public List<OrderVO> findByOrderStatus(Integer orderStatus);
}
