package com.order.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.Util;

public class OrderJDBCDAO implements OrderDAO_interface {
	private static final String INSERT_STMT = 
			"INSERT INTO customer_order (userNumber, orderStatus, establishmentTime, note, shippingTime, receiver, shippingAddress, deliveryFee, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = 
			"UPDATE customer_order set userNumber=?, orderStatus=?, establishmentTime=?, note=?, shippingTime=?, receiver=?, shippingAddress=?, deliveryFee=?, total=? where orderNumber = ?";
	private static final String GET_ONE_STMT_BY_PK = 
			"SELECT * FROM customer_order where orderNumber = ?";
	private static final String GET_ALL_STMT = 
			"SELECT * FROM customer_order order by orderNumber";
	private static final String GET_STMT_BY_USER_NUMBER =
			"SELECT * FROM customer_order where userNumber = ? order by userNumber";
	private static final String GET_USER_NUMBER =
			"SELECT userNumber FROM customer_order group by userNumber";
	private static final String GET_STMT_BY_ORDER_STATUS =
			"SELECT * FROM customer_order where orderStatus = ? order by orderNumber";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
		}
	}
	
	
	@Override
	public void insert(OrderVO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, orderVO.getUserNumber());
			pstmt.setInt(2, orderVO.getOrderStatus());
			pstmt.setTimestamp(3, orderVO.getEstablishmentTime());
			pstmt.setString(4, orderVO.getNote());
			pstmt.setTimestamp(5, orderVO.getShippingTime());
			pstmt.setString(6, orderVO.getReceiver());
			pstmt.setString(7, orderVO.getShippingAddress());
			pstmt.setBigDecimal(8, orderVO.getDeliveryFee());
			pstmt.setBigDecimal(9, orderVO.getTotal());

			pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, null);
		}
		
	}

	@Override
	public void update(OrderVO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, orderVO.getUserNumber());
			pstmt.setInt(2, orderVO.getOrderStatus());
			pstmt.setTimestamp(3, orderVO.getEstablishmentTime());
			pstmt.setString(4, orderVO.getNote());
			pstmt.setTimestamp(5, orderVO.getShippingTime());
			pstmt.setString(6, orderVO.getReceiver());
			pstmt.setString(7, orderVO.getShippingAddress());
			pstmt.setBigDecimal(8, orderVO.getDeliveryFee());
			pstmt.setBigDecimal(9, orderVO.getTotal());
			pstmt.setInt(10, orderVO.getOrderNumber());

			pstmt.executeUpdate();
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, null);
		}

	}

	@Override
	public OrderVO findByPrimaryKey(Integer orderNumber) {
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT_BY_PK);
			
			pstmt.setInt(1, orderNumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderNumber(rs.getInt("orderNumber"));
				orderVO.setUserNumber(rs.getInt("userNumber"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setEstablishmentTime(rs.getTimestamp("establishmentTime"));
				orderVO.setNote(rs.getString("note"));
				orderVO.setShippingTime(rs.getTimestamp("shippingTime"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setShippingAddress(rs.getString("shippingAddress"));
				orderVO.setDeliveryFee(rs.getBigDecimal("deliveryFee"));
				orderVO.setTotal(rs.getBigDecimal("total"));				
			}
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, rs);
		}
		
		return orderVO;
	}

	@Override
	public List<OrderVO> getAll() {
		List<OrderVO> list = new ArrayList<>();
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderNumber(rs.getInt("orderNumber"));
				orderVO.setUserNumber(rs.getInt("userNumber"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setEstablishmentTime(rs.getTimestamp("establishmentTime"));
				orderVO.setNote(rs.getString("note"));
				orderVO.setShippingTime(rs.getTimestamp("shippingTime"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setShippingAddress(rs.getString("shippingAddress"));
				orderVO.setDeliveryFee(rs.getBigDecimal("deliveryFee"));
				orderVO.setTotal(rs.getBigDecimal("total"));
				list.add(orderVO);
			}
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, rs);
		}
		
		
		return list;
	}
	
	@Override
	public List<OrderVO> findByUserNumber(Integer userNumber) {
		List<OrderVO> list = new ArrayList<>();
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_STMT_BY_USER_NUMBER);
			
			pstmt.setInt(1, userNumber);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderNumber(rs.getInt("orderNumber"));
				orderVO.setUserNumber(rs.getInt("userNumber"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setEstablishmentTime(rs.getTimestamp("establishmentTime"));
				orderVO.setNote(rs.getString("note"));
				orderVO.setShippingTime(rs.getTimestamp("shippingTime"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setShippingAddress(rs.getString("shippingAddress"));
				orderVO.setDeliveryFee(rs.getBigDecimal("deliveryFee"));
				orderVO.setTotal(rs.getBigDecimal("total"));
				list.add(orderVO);
			}
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, rs);
		}

		return list;
	}
	
	@Override
	public List<OrderVO> getUserNumber() {
		List<OrderVO> list = new ArrayList<>();
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_USER_NUMBER);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderVO = new OrderVO();
				orderVO.setUserNumber(rs.getInt("userNumber"));
				list.add(orderVO);
			}
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, rs);
		}
		
		return list;
	}
	
	@Override
	public List<OrderVO> findByOrderStatus(Integer orderStatus) {
		List<OrderVO> list = new ArrayList<>();
		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_STMT_BY_ORDER_STATUS);
			
			pstmt.setInt(1, orderStatus);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderNumber(rs.getInt("orderNumber"));
				orderVO.setUserNumber(rs.getInt("userNumber"));
				orderVO.setOrderStatus(rs.getInt("orderStatus"));
				orderVO.setEstablishmentTime(rs.getTimestamp("establishmentTime"));
				orderVO.setNote(rs.getString("note"));
				orderVO.setShippingTime(rs.getTimestamp("shippingTime"));
				orderVO.setReceiver(rs.getString("receiver"));
				orderVO.setShippingAddress(rs.getString("shippingAddress"));
				orderVO.setDeliveryFee(rs.getBigDecimal("deliveryFee"));
				orderVO.setTotal(rs.getBigDecimal("total"));
				list.add(orderVO);
			}
			
			
		}catch(SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		}finally {
			Util.closeResources(con, pstmt, rs);
		}

		return list;
	}
	
	
	
	
	public static void main(String[] args) {
		OrderJDBCDAO dao = new OrderJDBCDAO();
		
		//新增
//		OrderVO order1 = new OrderVO();
//		order1.setUserNumber(4);
//		order1.setOrderStatus(1);
//		order1.setEstablishmentTime(Timestamp.valueOf(LocalDateTime.now()));
//		order1.setNote("新增訂單");
//		order1.setShippingTime(Timestamp.valueOf("2024-04-22 15:30:00"));
//		order1.setReceiver("新增收件人");
//		order1.setShippingAddress("新增地址");
//		order1.setDeliveryFee(50.0);
//		order1.setTotal(600.0);
//		dao.insert(order1);
		
		
		//修改
//		OrderVO order2 = new OrderVO();
//		order2.setOrderNumber(1);
//		order2.setUserNumber(4);
//		order2.setOrderStatus(2);
//		order2.setEstablishmentTime(Timestamp.valueOf(LocalDateTime.now()));
//		order2.setNote("修改訂單");
//		order2.setShippingTime(Timestamp.valueOf("2024-04-22 15:30:00"));
//		order2.setReceiver("修改收件人");
//		order2.setShippingAddress("修改地址");
//		order2.setDeliveryFee(150.0);
//		order2.setTotal(610.0);
//		dao.update(order2);
		
		
		//單一查詢
//		OrderVO order3 = dao.findByPrimaryKey(5);
//		
//		System.out.print(order3.getOrderNumber() + ",");
//		System.out.print(order3.getUserNumber() + ",");
//		System.out.print(order3.getOrderStatus()+ ",");
//		System.out.print(order3.getEstablishmentTime() + ",");
//		System.out.print(order3.getNote() + ",");
//		System.out.print(order3.getShippingTime() + ",");
//		System.out.print(order3.getReceiver() + ",");
//		System.out.print(order3.getShippingAddress() + ",");
//		System.out.print(order3.getDeliveryFee() + ",");
//		System.out.print(order3.getTotal());
//		System.out.println();
		
		
		
		
		//查詢全部
//		List<OrderVO> list = dao.getAll();
//		for (OrderVO orderVO : list) {
//			System.out.print(orderVO.getOrderNumber() + ",");
//			System.out.print(orderVO.getUserNumber() + ",");
//			System.out.print(orderVO.getOrderStatus()+ ",");
//			System.out.print(orderVO.getEstablishmentTime() + ",");
//			System.out.print(orderVO.getNote() + ",");
//			System.out.print(orderVO.getShippingTime() + ",");
//			System.out.print(orderVO.getReceiver() + ",");
//			System.out.print(orderVO.getShippingAddress() + ",");
//			System.out.print(orderVO.getDeliveryFee() + ",");
//			System.out.print(orderVO.getTotal());
//			System.out.println();
//		}
		
		//使用會員編號查詢
//		List<OrderVO> list = dao.findByUserNumber(5);
//		for (OrderVO orderVO : list) {
//			System.out.print(orderVO.getOrderNumber() + ",");
//			System.out.print(orderVO.getUserNumber() + ",");
//			System.out.print(orderVO.getOrderStatus()+ ",");
//			System.out.print(orderVO.getEstablishmentTime() + ",");
//			System.out.print(orderVO.getNote() + ",");
//			System.out.print(orderVO.getShippingTime() + ",");
//			System.out.print(orderVO.getReceiver() + ",");
//			System.out.print(orderVO.getShippingAddress() + ",");
//			System.out.print(orderVO.getDeliveryFee() + ",");
//			System.out.print(orderVO.getTotal());
//			System.out.println();
//		}
		
		
		//查詢全部的會員編號(不重複)
//		List<OrderVO> list = dao.getUserNumber();
//		for (OrderVO orderVO : list) {
//			System.out.print(orderVO.getUserNumber());
//			System.out.println();
//		}
		
		//使用訂單狀態查詢
		List<OrderVO> list = dao.findByOrderStatus(0);
		for (OrderVO orderVO : list) {
			System.out.print(orderVO.getOrderNumber() + ",");
			System.out.print(orderVO.getUserNumber() + ",");
			System.out.print(orderVO.getOrderStatus()+ ",");
			System.out.print(orderVO.getEstablishmentTime() + ",");
			System.out.print(orderVO.getNote() + ",");
			System.out.print(orderVO.getShippingTime() + ",");
			System.out.print(orderVO.getReceiver() + ",");
			System.out.print(orderVO.getShippingAddress() + ",");
			System.out.print(orderVO.getDeliveryFee() + ",");
			System.out.print(orderVO.getTotal());
			System.out.println();
		}

	}


}
