package kr.ac.hansung.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.CartDao;
import kr.ac.hansung.cse.model.Cart;

@Service
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public Cart getCartById(int cartId) {
		return cartDao.getCartById(cartId);
	}
	
}
