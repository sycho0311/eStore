package kr.ac.hansung.cse.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Cart;
import kr.ac.hansung.cse.model.CartItem;

@Repository
@Transactional
public class CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	public void removeCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItems();
		
		for (CartItem item : cartItems) {
			removeCartItem(item);
		}
	}

	@SuppressWarnings("unchecked")
	public CartItem getCartItemByProductId(int cartId, int productId) {
		Session session = sessionFactory.getCurrentSession();
		TypedQuery<CartItem> query = session.createQuery("from CartItem where cart.id = ? and product.id = ?");
		query.setParameter(0, cartId);
		query.setParameter(1, productId);
		
		return (CartItem) query.getSingleResult();
	}
	
	public boolean plusItem(CartItem cartItem, double totalPrice, int unitInStock) {
		
		Session session = sessionFactory.getCurrentSession();
		
		int quantity = cartItem.getQuantity();
		
		if (quantity >= unitInStock)
			return false;
		
		String hql = "update CartItem set quantity = :quantity, totalPrice = :totalPrice where id = :id";

		Query query = session.createQuery(hql);
		query.setParameter("quantity", quantity+1);
		query.setParameter("totalPrice", totalPrice * (quantity+1));
		query.setParameter("id", cartItem.getId());

		query.executeUpdate();
		
		return true;
	}

	public boolean minusItem(CartItem cartItem, double totalPrice) {
		
		Session session = sessionFactory.getCurrentSession();
		
		int quantity = cartItem.getQuantity();
		
		if (quantity <= 0)
			return false;
		
		String hql = "update CartItem set quantity = :quantity, totalPrice = :totalPrice where id = :id";

		Query query = session.createQuery(hql);
		query.setParameter("quantity", quantity-1);
		query.setParameter("totalPrice", totalPrice * (quantity-1));
		query.setParameter("id", cartItem.getId());

		query.executeUpdate();
		
		return true;
	}

}
